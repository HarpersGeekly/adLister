import com.codeup.adlister.dao.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RyanHarper on 2/1/17.
 */
public class MySqlAdsDao implements Ads {

    private Connection connection;
    // recipe for everything CRUD:
    public MySqlAdsDao(Config config) {
        Driver driver;
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);

            //mysql -u root -p or..
            //mysql-u adlister_user -p
            //use adlister_db
            connection = DriverManager.getConnection(
                    // "jdbc:mysql://localhost/adlister_db",
                    config.getUrl(),
                    // "adlister_user",
                    config.getUsername(),
                    // "adlister_pwd"
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //recipe for select:
    // get a list of all the ads
    public List<Ad> all() {

        // select * from ads saved into a String.
        String selectQuery = "SELECT * FROM ads";

        // create a new List
        List<Ad> ads = new ArrayList<>();

        //create a new statement from your current DB connection. (Statement is an object interface)
        Statement statement;
        try {
            statement = connection.createStatement();
            // execute the query and save it in a resultset temporary table.
            ResultSet resultSet = statement.executeQuery(selectQuery);
            // iterate through the resultset...while(true or false)...
            while (resultSet.next()) { //moving to the next available row
                //transform the result set into a List of models (ads)
                // use the rs.getLong(), getString(), methods to grab values from the row (in the db)
                long id = resultSet.getLong("id");
                long userId = resultSet.getLong("user_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                // use those values to instantiate a new Ad object, passing them to the constructor
                Ad ad = new Ad(id, userId, title, description);
                // add that new Ad object to the ads arrayList
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    // insert into ads (column1, column2, column3) values (value1, value2, value3)
    // to be safe from vulnerabilities we use "?"
    public void insert(Ad ad) {

        String sql = "INSERT INTO ads (user_id, title, description) " +
                "VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, ad.getUserId());
            statement.setString(2,ad.getTitle());
            statement.setString(3,ad.getDescription());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();

            long id = generatedKeys.getLong(1);
            ad.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ad findById(long id) {
        String sql = "SELECT * FROM ads WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Long userId = resultSet.getLong("user_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                return new Ad(id, userId, title, description);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}