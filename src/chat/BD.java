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
            String url = "jdbc:sqlite:/home/oseias/NetBeansProjects/joe-chat/chat.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
    public void insertUser()
    {
        
    }
    public void insertChat(String senderId, String receiverId, String msgContent, String date) 
    {
        int p1 = 1;
        int p2 = 2;
        
        
        try {
            PreparedStatement id = conn.prepareStatement("SELECT id_user FROM users WHERE name=?");
            id.setString(1,senderId);
//            System.out.println("Inicio Select");
            ResultSet rs= id.executeQuery();
            if(rs.next())
            {
//                System.out.println("entrei");
                p1 = rs.getInt("id_user");
//                System.out.println("P1: "+ p1);
            }
            else
                return;
            
            id.setString(1,receiverId);
            rs= id.executeQuery();
            if(rs.next())
            {
                p2 = rs.getInt("id_user");
//                System.out.println("P2: "+ p2);
            }
            else
                return;
            id.close();
            System.out.println("Insertion");
            PreparedStatement q = conn.prepareStatement("INSERT INTO CHAT (sender,receiver,content,dt) VALUES(?,?,?,?)");
            q.setInt(1,p1);
            q.setInt(2,p2);
            q.setString(3,msgContent);
            q.setString(4,date);
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
            PreparedStatement id = conn.prepareStatement("select sender,receiver,content,dt from chat c where c.sender in (SELECT id_user FROM users where name = ? or name = ?) and c.receiver in (SELECT id_user FROM users where name = ? or name = ? ) order by dt");
            
            id.setString(1,senderId);
            id.setString(2,receiverId);
            id.setString(3,senderId);
            id.setString(4,receiverId);
          
           
            ResultSet rs= id.executeQuery();
            while(rs.next())
            {   
                Chatter obj = new Chatter(senderId,receiverId,rs.getString("content"),rs.getString("dt")); 
                content.add(obj);
                
            }
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return content;
        
    }
    
}
