import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

/**
 * Created by RyanHarper on 2/1/17.
 */
public class JdbcAdsDao implements Ads {
//    After we implemented with command + enter to bring in the methods, we updated pom.xml with a new dependency...
//            If a dependency isn't readily available like it was for us in the slides, go to Google and search
//              "mysql maven", click the top link, and choose the most recent file in the directory

    private Connection connection;

    public JdbcAdsDao() throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);


        //think of the next as this in the terminal:
        // mysql -u root -p
        //use database adlister_db;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/adlister_db",
                "root",
                "codeup"
        );
    }

    @Override
    public List<Ad> all()  {
        // drive the query:
        String sql = "SELECT * FROM ads";

        try {
            //create a statement:
            Statement statement = connection.createStatement();
            //pass sql:
            ResultSet resultSet = statement.executeQuery(sql);
            //iterate over the resultSet:
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                //with these two values I can create an Ad.
                Ad ad = new Ad(id, title, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
