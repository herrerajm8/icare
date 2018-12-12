/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

/**
 *
 * @author Administrator
 */
public abstract class CoR_VerifierHandler {
    protected CoR_VerifierHandler m_successor;
    public void setSuccessor(CoR_VerifierHandler successor)
    {
        m_successor = successor;
    }

    public abstract boolean handleRequestImpl(CoR_VerifierRequest request);

    public final void handleRequest(CoR_VerifierRequest request)
    {
        boolean handledByThisNode = this.handleRequestImpl(request);

        if (m_successor != null && !handledByThisNode){
            m_successor.handleRequest(request);
        }
        
    }
    
    
}
