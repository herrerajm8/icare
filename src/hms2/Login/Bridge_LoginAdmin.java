/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Login;

import View.AdminHome4;

/**
 *
 * @author Administrator
 */
public class Bridge_LoginAdmin implements Bridge_LoginImplementor {

    @Override
    public void redirectUser() {
        new AdminHome4().setVisible(true);
        
    }
    
}
