/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class CoR_LoginIsAdmin extends CoR_LoginHandler {
    
    private static CoR_LoginIsAdmin instance;
    private int id;
    
    public CoR_LoginIsAdmin(){
        
    }
    
    public static synchronized CoR_LoginIsAdmin instance(){
        if (instance == null) {
            instance = new CoR_LoginIsAdmin();
        }
        return instance;
    }
    
    public boolean getIsAdmin(int userid){
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet res=null;
            Statement st = null;
            String sql = null;
            boolean ult = false;
            
            try{
                this.id = userid;
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=convertToNull","root","");
                st = conn.createStatement();

                sql = "SELECT isAdmin FROM  users WHERE user_id = "  + userid;
                System.out.println(sql);
                res = st.executeQuery(sql);
                if(res.next()){
                    if(res.getInt("isAdmin") == 1) {
                         ult = true;
                         System.out.println("naabot");
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error(logadd): " + e.getMessage());
            }
            return ult;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public boolean handleRequestImpl(CoR_Request request) {
        boolean res;
        if(getIsAdmin(request.getValue())) {
            System.out.println("Adtos admin");
            Bridge_Login brid = new Bridge_LoginImp(new Bridge_LoginAdmin());
            brid.loginUser(request.getUI());
            res = true;
        } else{
            res = false;
        }
        
        return res;
    }
}
