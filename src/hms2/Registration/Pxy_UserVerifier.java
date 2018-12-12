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
public interface Pxy_UserVerifier {
    public boolean useVerify(String Username, String password, String fname, String lname, String utype, String spec);
    
    
}
