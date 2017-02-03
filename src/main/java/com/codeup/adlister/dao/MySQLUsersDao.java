package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * Created by RyanHarper on 2/3/17.
 */
public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? ";
        // the '?' is used for prepared statements.
        try {
            //create a prepared statement and pass the sql:
            PreparedStatement statement = connection.prepareStatement(sql);
            //find the parameters:
            statement.setString(1, username);
            //now execute the query and it will return a ResultSet:
            ResultSet resultSet = statement.executeQuery();
            //check if user isn't there and create a new user
            if(!resultSet.next()) {
                return null;
            }
            return new User(resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users (username, email, password) " +
                "VALUES (?, ?, ?)";
        try {
                PreparedStatement statement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
            //bind
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
            //execute to get a resultSet

                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();

                return generatedKeys.getLong(1);

            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new ad.", e);
            }
    }
}
