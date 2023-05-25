package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {


    // Database Connection
    private Connection connection = null;


    // Database Connection

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {

        try {

            String findUser = "SELECT * FROM users WHERE username = ? ";

            PreparedStatement stmt = connection.prepareStatement(findUser);

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            User newUser = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));


            return newUser;


        } catch (SQLException e) {


            throw new RuntimeException("Unable to find a user", e);


        }

    }

    @Override
    public Long insert(User user) {

        // Try method allows us to handle exceptions

        try {

            // THe insertUser variable contains out SQL statement

            String insertUser = "INSERT INTO users (username,email,password) VALUES(?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);

            // The stmt.set method allows us to dynamically set values to the correct data type based on the fields.
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            return rs.getLong(1);


        } catch (SQLException e) {

            throw new RuntimeException("Error adding a user to the database", e);


        }


    }


}


