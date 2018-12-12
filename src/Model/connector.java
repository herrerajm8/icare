/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class connector {
    public static Connection getConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/moneybag?zeroDateTimeBehavior=convertToNull","root","");
        return cn;
    }
}
