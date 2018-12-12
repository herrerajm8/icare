/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Login;

import hms2.Registration.Factory_UserCreator;
import hms2.Registration.Factory_Users;
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
public class LoginUserPass {
    private static LoginUserPass instance;
    public LoginUserPass(){
        
    }
    
    public static synchronized LoginUserPass instance(){
        if (instance == null) {
            instance = new LoginUserPass();
        }
        return instance;
    }
    
    public int userPass(String Username, String Password){
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet res=null;
            Statement st = null;
            String sql = null;
            int ult = -1;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=convertToNull","root","");
                st = conn.createStatement();

                sql = "SELECT user_id FROM users WHERE password = '"  + Password + "' AND username = '"+ Username +"'";
                System.out.println(sql);
                res = st.executeQuery(sql);
                if(res.next()){
                    ult = res.getInt("user_id");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error(logpass): " + e.getMessage());
            }
            return ult;
    }
}
