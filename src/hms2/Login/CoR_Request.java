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
public class CoR_Request {
    private int m_value;
    private String m_description;
    private Login m_login;

    public CoR_Request(String description, int value, Login login)
    {
            m_description = description;
            m_value = value;
            m_login = login;
    }

    public int getValue()
    {
            return m_value;
    }

    public Login getUI()
    {
            return m_login;
    }
    
    public String getDescription()
    {
            return m_description;
    }          
}
