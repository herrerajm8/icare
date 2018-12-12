/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

/**
 *
 * @author Administrator
 */
public class NurList {

    public int getNur_id() {
        return nur_id;
    }

    public int getU_id() {
        return u_id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getM_name() {
        return m_name;
    }

    
    private int nur_id;
    private int u_id;
    private String f_name;
    private String l_name;
    private String m_name;
    
    public NurList(int nur_id,int u_id,String f_name,String l_name,String m_name){
        this.nur_id=nur_id;
        this.u_id=u_id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.m_name=m_name;
    }
}
