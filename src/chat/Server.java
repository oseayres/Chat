/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class Server extends java.rmi.server.UnicastRemoteObject implements Ichat
{
    private ArrayList<String> names;
    
    public static void main(String args[])
    {
        try
        {
            Server s = new Server();
            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("joe-chat",(Remote) s);
        }
        catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }
    
    public Server() throws RemoteException
    {
        this.names = new ArrayList<>();
    }
    

    @Override
    public String connect(String user_name) throws RemoteException
    {
        names.add(user_name);
        
        return user_name;
    }
    public void disconnect(String id)
    {   
        names.remove(id);
        
    }
    @Override
    public ArrayList<String> listOfClients()
    {
        return this.names;
    }
    
}
