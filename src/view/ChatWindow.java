package view;

import chat.Client;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jp
 */
public class ChatWindow extends javax.swing.JFrame
{
    private chat.Client client;
    private view.Login screenLogin;
    private String user_name;

    /**
     * Creates new form ChatWindow2
     * @param user_name
     * @param client
     * @param screenLogin
     * @throws java.lang.Exception
     */
    public ChatWindow(String user_name, view.Login screenLogin) throws Exception
    {
        initComponents();
               
        this.user_name = user_name;
        this.screenLogin = screenLogin;
    }
    
    
    public void writeAllUsers(ArrayList<String> users)
    {
        jListAllUsers.removeAll();
        DefaultListModel listModel = new DefaultListModel();
        for (String user : users) {
            listModel.addElement(user);
        }
        jListAllUsers.setModel(listModel);
    }



    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAllUsers = new javax.swing.JList<>();
        jPanelTextMsg = new javax.swing.JPanel();
        jTextFieldMsg = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneChat = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabelTitle.setText("Chat ");

        jListAllUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAllUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAllUsers);

        jTextFieldMsg.setToolTipText("Digite sua mensagem aqui");

        jButtonSend.setText("Enviar");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTextMsgLayout = new javax.swing.GroupLayout(jPanelTextMsg);
        jPanelTextMsg.setLayout(jPanelTextMsgLayout);
        jPanelTextMsgLayout.setHorizontalGroup(
            jPanelTextMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextMsgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButtonSend)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanelTextMsgLayout.setVerticalGroup(
            jPanelTextMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextMsgLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelTextMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jTextPaneChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabelTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelTextMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTextMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        setSize(new java.awt.Dimension(612, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:

            client.destroy();
        } catch (RemoteException ex) {
            Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.screenLogin.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSendActionPerformed
    {//GEN-HEADEREND:event_jButtonSendActionPerformed
        // TODO add your handling code here:
        String textSubmit = jTextFieldMsg.getText();
//        jTextPane1.setText(textSubmit);
        StyledDocument doc = jTextPaneChat.getStyledDocument();
        
        SimpleAttributeSet keyword = new SimpleAttributeSet();
        StyleConstants.setForeground(keyword, Color.white);
        StyleConstants.setBackground(keyword, Color.black);
//        StyleConstants.set
        StyleConstants.setBold(keyword, true);
        try
        {
            doc.insertString(doc.getLength(), textSubmit +"\n", keyword);
        }
        catch(Exception e)
        {
                // error
        }
        
        // find who is sender
        String receiver;
        receiver = jListAllUsers.getSelectedValue();
        jTextFieldMsg.setText("");
//        JOptionPane.showMessageDialog(this, receiver);
        

//        client.sendMessage(receiver,textSubmit);
         
        
        
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        jLabelTitle.setText("Seja bem vindo " + user_name);
        
        try
        {
            client = new chat.Client(this, user_name);
            client.init();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        
        
        this.getRootPane().setDefaultButton(jButtonSend);
        jTextPaneChat.setBackground(Color.red);
        jTextPaneChat.setText("Selecione alguem");
          
    }//GEN-LAST:event_formWindowOpened

    private void jListAllUsersMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jListAllUsersMouseClicked
    {//GEN-HEADEREND:event_jListAllUsersMouseClicked
        // TODO add your handling code here:
        jTextPaneChat.setText("");
        // faz uma busca pelo historico de conversa com a pessoa selecionada
        jTextPaneChat.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_jListAllUsersMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
//                new ChatWindow(null).setVisible(true);
            }
        });
    }
    public void hello(String s)
    {
        JOptionPane.showMessageDialog(this, s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListAllUsers;
    private javax.swing.JPanel jPanelTextMsg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldMsg;
    private javax.swing.JTextPane jTextPaneChat;
    // End of variables declaration//GEN-END:variables
}
