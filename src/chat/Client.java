/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Client
{
    private Ichat remote_ref;
    private view.ChatWindow2 view_ref;
    private String user_name;
    private ArrayList<String> clients;
    
    
    public static void main(String args[])
    {
        new view.Login().setVisible(true);
    }
    
    
    public Client(view.ChatWindow2 view_ref, String user_name) throws Exception
    {
        try
        {
            this.remote_ref = (Ichat) Naming.lookup("rmi://localhost:1099/joe-chat");
            String id;
            id = remote_ref.connect(user_name);
            if (true)
            {
                
                view_ref.hello("Seja bem vindo " + user_name);
                // requisiton of list
                clients = remote_ref.listOfClients();
                view_ref.writeAllUsers(clients);
                
                
                
                
            }
                
            else
                view_ref.hello("Erro ao conectar ao servidor");
            
        }
        catch (Exception ex)
        {
            throw ex;
        }
        
        this.view_ref = view_ref;
        this.user_name = user_name;
    }
    public void destroy() throws RemoteException
    {
        this.remote_ref.disconnect(user_name);
    }
//    public ArrayList<String> getClients()
//    {
//        
//    }
}
