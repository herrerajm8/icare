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
public class CoR_LoginNurse extends CoR_LoginHandler {
    private static CoR_LoginNurse instance;
    int id;
    
    public CoR_LoginNurse(){
        
    }
    
    public static synchronized CoR_LoginNurse instance(){
        if (instance == null) {
            instance = new CoR_LoginNurse();
        }
        return instance;
    }
    
    public boolean getNurse(int userid){
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        Statement st = null;
        String sql = null;
        boolean ult = false;

        try{
            instance().id = userid;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=convertToNull","root","");
            st = conn.createStatement();

            sql = "SELECT t1.user_id FROM  users AS t1 JOIN nurselist AS t2 ON t1.user_id = t2.user_id WHERE t1.user_id = "  + userid;
            System.out.println(sql);
            res = st.executeQuery(sql);
            if(res.next()){
                System.out.println("Adtos skra");
                if(res.getInt("user_id") >= 0) {
                    System.out.println("Adtos skrask");
                     ult = true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error(lognur): " + e.getMessage());
        }
        return ult;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public boolean handleRequestImpl(CoR_Request request) {
        boolean res;
        if(getNurse(request.getValue())) {
            System.out.println("Adtos nurse");
            Bridge_Login brid = new Bridge_LoginImp(new Bridge_LoginNurse());
            brid.loginUser(request.getUI());
            res = true;
        } else{
            res = false;
        }
        
        return res;
    }
}
