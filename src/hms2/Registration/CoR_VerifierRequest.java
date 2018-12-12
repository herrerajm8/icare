/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

import hms2.Login.Login;

/**
 *
 * @author Administrator
 */
public class CoR_VerifierRequest {
    private String m_uname;
    private String m_pword;
    private String m_fname;
    private String m_lname;
    private String m_utype;
    private String m_spec;
    

    public CoR_VerifierRequest(String Username, String password, String fname, String lname, String utype ,String spec)
    {
            this.m_uname = Username;
            this.m_pword = password;
            this.m_fname = fname;
            this.m_lname = lname;
            this.m_utype = utype;
            this.m_spec = spec;
    }

    public String getPword()
    {
            return m_pword;
    }

    public String getUname()
    {
            return m_uname;
    }
    
    public String getFname()
    {
            return m_fname;
    }
    
    public String getLname()
    {
            return m_lname;
    }
    
    public String getSpec()
    {
            return m_spec;
    }
}
