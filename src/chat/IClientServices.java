/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author jp
 */
public interface IClientServices extends java.rmi.Remote
{
    public void updateListOfClients() throws java.rmi.RemoteException;
}
