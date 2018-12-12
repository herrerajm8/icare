/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class CoR_VerFname extends CoR_VerifierHandler {

    @Override
    public boolean handleRequestImpl(CoR_VerifierRequest request) {
        boolean res = false; 
        if(request.getFname().compareTo("") == 0){
            Pxy_RealVerifier.instance().setRes(false);
            JOptionPane.showMessageDialog(null, "Empty First Name Field!");
            res = true;
        }else{
            res = false;
        }
        
        return res;
    }
    
}
