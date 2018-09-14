/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.ArrayList;

/**
 *
 * @author jp
 */
public interface Ichat extends java.rmi.Remote
{
    public String connect(String user_name) throws java.rmi.RemoteException;
    public ArrayList<String> listOfClients() throws java.rmi.RemoteException;
    public void disconnect(String id) throws java.rmi.RemoteException;
}
