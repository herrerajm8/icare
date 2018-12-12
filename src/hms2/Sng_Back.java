/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2;

import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Sng_Back {
    private static Sng_Back instance;
    private JFrame previousPage;
    
    
    public static synchronized Sng_Back instance(){
        if (instance == null) {
            instance = new Sng_Back();
        }
        return instance;
    }
    
    public void goPreviousPage(JFrame thisPage) {
        
        thisPage.setVisible(false);
        previousPage.setVisible(true);
        setPreviousPage(thisPage);
    }

    
    public void setPreviousPage(JFrame previousPage) {
        this.previousPage = previousPage;
    }
}
