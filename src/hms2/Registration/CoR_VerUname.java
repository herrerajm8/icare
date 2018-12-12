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
public class CoR_VerUname extends CoR_VerifierHandler{

    @Override
    public boolean handleRequestImpl(CoR_VerifierRequest request) {
        boolean res = false; 
        System.out.println("verifying uname");
        if(request.getUname().compareTo("") == 0){
            System.out.println("nasod");
            Pxy_RealVerifier.instance().setRes(false);
            JOptionPane.showMessageDialog(null, "Empty Username Field!");
            res = true;
        }else{
            res = false;
        }
        
        return res;
    }
    
}
