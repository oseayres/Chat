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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oseias
 */
public class BD {
    
    public Connection conn;
    
    public BD()
    {
        // make connection with database 
        conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:chat.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
        
    }
    
    
    public void insertUser()
    {
        
    }
    
    
    public void insertChat(String senderId, String receiverId, String msgContent, String date) 
    {
        int p1 = 1;
        int p2 = 2;
        
        
        try
        {
            PreparedStatement q = conn.prepareStatement("INSERT INTO CHAT (sender, receiver, content, dt) VALUES(?,?,?,?)");
            q.setString(1, senderId);
            q.setString(2, receiverId);
            q.setString(3, msgContent);
            q.setString(4, date);
            q.execute();
            q.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        
    }

    
    public ArrayList<Chatter> getChatter(String senderId, String receiverId) {

        ArrayList<Chatter> content = new ArrayList<>();
        
        try {
            // select content,dt from chat c where c.sender in (SELECT id_user FROM users where name = 'marco' or name = 'ze') and c.receiver in (SELECT id_user FROM users where name = 'ze' or name = 'marco' ) order by dt; 
//            System.out.println("Init getChatter");
            PreparedStatement id = conn.prepareStatement("select * from chat c where c.sender in (?, ?) and c.receiver in (?, ?) order by dt");
            
            id.setString(1, senderId);
            id.setString(2, receiverId);
            id.setString(3, senderId);
            id.setString(4, receiverId);
          
           
            ResultSet rs = id.executeQuery();
            while(rs.next())
            {   
                Chatter obj = new Chatter(rs.getString("sender"), rs.getString("receiver"),
                        rs.getString("content"), rs.getString("dt")); 
                content.add(obj);
                
            }
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return content;
        
    }
    
}
