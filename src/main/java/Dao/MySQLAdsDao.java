package Dao;

import Models.Ad;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {


    private Connection connection;


    public MySQLAdsDao(Config config) {


        // The try/catch method contains our database configurations.


        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to a database");
        }


    }


    @Override
    public List<Ad> all() {

        try {

            Statement stm = connection.createStatement();
            String selectAds = "SELECT * FROM ads";
            ResultSet rs = stm.executeQuery(selectAds);
            List<Ad> allAds = new ArrayList<>();
            while (rs.next()) {

                allAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("tittle"), rs.getString("description")));

            }

            return allAds;


        } catch (Exception e) {
            throw new RuntimeException("Error creating connection");


        }
    }

    @Override
    public Long insert(Ad ad) {

        try {
            Statement stm = connection.createStatement();

            String insertQuery = String.format("INSERT INTO ads(user_id, title, description) VALUES ('%s', '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());

            stm.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stm.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("insert id" + rs.getLong(1));

            }
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error adding ad");


        }


    }


}
