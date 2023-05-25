package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {



    private Connection connection = null;


    // Our MySQLAdsDao takes a parameter from our Config class and contains all the necessary objects that our needed to establish a connection (not to confuse the connection object) with our database.


    public MySQLAdsDao(Config config) {
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


    // The all method holds our SQL statements which retrieves all the columns from our ads tables. This method has been declared in the Ads Interface

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM ads";

            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.");
        }
    }

    // The insert method accepts values for the Ad object from the user and adds them to our database

    @Override
    public Long insert(Ad ad) {
        try {


            PreparedStatement stmt = connection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (Exception e) {
            throw new RuntimeException("Error creating a new ad.");
        }

    }

    // The createInsertQuery is a method used in conjunction to our insert method and essentially is used to separate code from our query.

    private String createInsertQuery() {
        return "INSERT INTO ads(user_id, title, description) VALUES (?,?,?)";


    }

    // Our extractAd method is designed to display our add. The Result instance gets the data with respect to what is described within the Ad bean.

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }



    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
