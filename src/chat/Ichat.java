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
public interface Ichat extends java.rmi.Remote
{
    public String connect(String user_name) throws java.rmi.RemoteException;
}
