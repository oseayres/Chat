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
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class Server extends java.rmi.server.UnicastRemoteObject implements Ichat
{
    private ArrayList<String> names;
    private ArrayList<IClientServices> clients_interfaces;
    
    public static void main(String args[])
    {
        try
        {
            Server s = new Server();
            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry r = LocateRegistry.createRegistry(1099);
            Naming.rebind("joe-chat",(Remote) s);
            
//            Thread.sleep(3000);
//            Naming.unbind("joe-chat");
//            UnicastRemoteObject.unexportObject(r, true);
//            UnicastRemoteObject.unexportObject(s, true);
            
//            LocateRegistry.getRegistry();
        }
        catch (Exception e) {
            System.err.println("Problema: " + e);
        }
    }
    
    public Server() throws RemoteException
    {
        this.names = new ArrayList<>();
        this.clients_interfaces = new ArrayList<>();
    }
    

    @Override
    public String connect(String user_name) throws RemoteException
    {
        names.add(user_name);
        
        System.out.println("List of clients:");
        for (int i = 0; i < names.size(); i++)
            System.out.println(names.get(i));
                
        return user_name;
    }
    
    
    @Override
    public String activateClient(String client_id) throws RemoteException
    {
        try
        {
            // Register the interface of the client
            IClientServices c_ref = (IClientServices) Naming.lookup("rmi://localhost:1099/"
                + client_id);
            clients_interfaces.add(c_ref);
            
            
            // Notify every other clients
            for (int i = 0; i < clients_interfaces.size() - 1; i++)
            {
                clients_interfaces.get(i).updateListOfClients();
            }
            
            return "OK";
        }
        catch (Exception ex)
        {
            System.err.println(ex);
            return ex.toString();
        }
    }
    
    
    @Override
    public void disconnect(String id)
    {    
        try
        {
            // Remove client
            int idx = names.indexOf(id);
            names.remove(idx);
            clients_interfaces.remove(idx);
            
            // Notify every other clients
            for (int i = 0; i < clients_interfaces.size(); i++)
            {
                clients_interfaces.get(i).updateListOfClients();
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }
    
    
    @Override
    public ArrayList<String> listOfClients()
    {
        return this.names;
    }

    @Override
    public void managerMessage(String senderId, String receiverId, String msgContent) throws RemoteException
    {
//        System.out.println("Routing...");
        int idx = names.indexOf(receiverId);
        this.clients_interfaces.get(idx).recvMsgFromServer(senderId,msgContent);
    }
}
