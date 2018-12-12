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
public class Pxy_VerifierProxy implements Pxy_UserVerifier {
    private boolean res = true;
    private Pxy_UserVerifier pxdverify;
    
    public Pxy_VerifierProxy() {
        	
    }
    
    @Override
    public boolean useVerify(String Username, String password, String fname, String lname,String utype, String spec) {
        pxdverify =  Pxy_RealVerifier.instance();
        
        res = pxdverify.useVerify(Username, password, fname, lname, utype, spec);
        
        return res;
    }
}
