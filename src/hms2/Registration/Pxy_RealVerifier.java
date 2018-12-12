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
public class Pxy_RealVerifier implements Pxy_UserVerifier {
    private static Pxy_RealVerifier instance;
    private boolean res = true;
    
    public Pxy_RealVerifier(){
        
    }
    
    public static synchronized Pxy_RealVerifier instance(){
        if (instance == null) {
            instance = new Pxy_RealVerifier();
        }
        return instance;
    }
    
    public void setRes(boolean res) {
        this.res = res;
    }

    @Override
    public boolean useVerify(String Username, String password, String fname, String lname, String utype, String spec) {
        // Setup Chain of Responsibility
        CoR_VerifierHandler h1 = new CoR_VerUname();
        CoR_VerifierHandler h2 = new CoR_VerPword();
        CoR_VerifierHandler h3 = new CoR_VerFname();
        CoR_VerifierHandler h4 = new CoR_VerLname();
        CoR_VerifierHandler h5 = new CoR_VerSpec();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.setSuccessor(h4);
        h4.setSuccessor(h5);

        // Send requests to the chain
        h1.handleRequest(new CoR_VerifierRequest(Username, password, fname, lname, utype, spec));
        
        return this.res;
    }
    
}
