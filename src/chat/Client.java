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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Client
{
    private Ichat remote_ref;
    private view.Login view_ref;
    private String user_name;
    
    
    public static void main(String args[])
    {
        new view.Login().setVisible(true);
    }
    
    
    public Client(view.Login view_ref, String user_name) throws Exception
    {
        try
        {
            this.remote_ref = (Ichat) Naming.lookup("rmi://localhost:1099/joe-chat");
            if (remote_ref.connect(user_name).equals("OK"))
                view_ref.hello("Seja bem vindo " + user_name);
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
}
