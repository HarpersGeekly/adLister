import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RyanHarper on 2/1/17.
 */
public class MySqlAdsDao implements Ads {

    private Connection connection;


    public MySqlAdsDao(Config config) {
        Driver driver;
        try {
            driver = new Driver();
            DriverManager.registerDriver(driver);


            //mysql -u root -p
            //use database adlister_db
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // get a list of all the ads
    public List<Ad> all() {

        // select * from ads
        String selectQuery = "SELECT * FROM ads";

        // create a new List
        List<Ad> ads = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                // add a new Ad object to the ads list inside this loop
                // use the rs.getLong(), getString(), methods to grab values from the row (in the db)
                long id = resultSet.getLong("id");
                long userId = resultSet.getLong("user_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                // use those values to instantiate a new Ad object, passing them to the constructor
                Ad ad = new Ad(id, userId, title, description);

                System.out.println("id: " + resultSet.getLong("id"));
                System.out.println("title: " + resultSet.getString("title"));
                System.out.println("title: " + resultSet.getString("description"));

                // add that new Ad object to the ads arrayList
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return ads;
    }
    public Long insert(Ad ad) {
        // insert into ads (column1, column2, column3) values (value1, value2, value3)

        return null;
    }

    public Ad find(int id) {

        // select * from ads where id = id
        return null;
    }

}