/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Login;

/**
 *
 * @author Administrator
 */
public class Bridge_LoginImp implements Bridge_Login{
    private Bridge_LoginImplementor imple= null;
    
    public Bridge_LoginImp(Bridge_LoginImplementor imp) {
        this.imple = imp;
    }
    
    @Override
    public void loginUser(Login log) {
        log.setVisible(false);
        imple.redirectUser();
    }
    
    
    
    
}
