/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */


class RMIWorker extends java.rmi.server.UnicastRemoteObject implements IClientServices
{
    private Client client;
    private String client_id;
    private Registry r;
    
    public RMIWorker(Client client, String client_id) throws java.rmi.RemoteException
    {
        this.client = client;
        this.client_id = client_id;
    }
    
    public void init()
    {
        try
        {
            System.setProperty("java.rmi.server.hostname", "localhost");
            
            int port = 25000;
            boolean flag = true;
            while (flag && port < 60000)
            {
                try
                {
                    r = LocateRegistry.createRegistry(port);
                    flag = false;
                }
                
                catch (RemoteException e)
                {
                    port++;
                }
            }
            
            System.out.println("client_id: " + client_id + "  port: " + port);
            
            Naming.rebind(client_id, (Remote) this);
            for (String string : Naming.list(client_id))
            {
                System.out.println(string);
            }
        }
        catch (Exception e)
        {
            System.err.println("Problema: " + e);
        }
    }
    
    public void die()
    {
        try
        {
            Naming.unbind(client_id);
            UnicastRemoteObject.unexportObject(r, true);
            UnicastRemoteObject.unexportObject(this, true);
        } catch (Exception ex) {}
    }
    
    @Override
    public void updateListOfClients() throws RemoteException
    {
        System.out.println("updateListOfClients");
        client.updateListOfClients();
    }
}



public class ClientServices implements Runnable
{
    private Client client;
    private String client_id;
    private RMIWorker w;
    
    public ClientServices(Client client, String client_id)
    {
        this.client = client;
        this.client_id = client_id;
    }

    
    @Override
    public void run()
    {
        try
        {
            w = new RMIWorker(client, client_id);
            w.init();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void die()
    {
        try
        {
            w.die();
        } catch (Exception ex) {}
    }
    
}
