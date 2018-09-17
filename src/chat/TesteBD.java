/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class TesteBD {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/jp/hello.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
//            Statement stmt = conn.createStatement();
//            String sql = "INSERT INTO teste (id, st) " +
//                        "VALUES (3, '');"; 
//            stmt.executeUpdate(sql);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String s = dtf.format(now);

//            PreparedStatement q = conn.prepareStatement("insert into teste (id, dt) values (?, ?)");
//            q.setInt(1, 3);
//            q.setString(2, s);
//            
//            q.execute();
//            q.close();

            PreparedStatement q = conn.prepareStatement("select id from teste where dt > ?");
            q.setString(1, "2018-09-09 12:00:00");
            
            ResultSet rs = q.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString("id"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}