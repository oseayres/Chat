/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.Serializable;

/**
 *
 * @author oseias
 */
public class Chatter implements Serializable {
    public String sender;
    public String receiver;
    public String content;
    public String date;
    
    public Chatter(String sender,String receiver,String content,String date)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.date = date;
    }
    
}
