/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Login;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public abstract class CoR_LoginHandler {
    protected CoR_LoginHandler m_successor;
    public void setSuccessor(CoR_LoginHandler successor)
    {
        m_successor = successor;
    }

    public abstract boolean handleRequestImpl(CoR_Request request);

    public final void handleRequest(CoR_Request request)
    {
        boolean handledByThisNode = this.handleRequestImpl(request);

        if (m_successor != null && !handledByThisNode){
            m_successor.handleRequest(request);
        }
            
        
    }      
}
