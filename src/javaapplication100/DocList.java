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
public class DocList {

    public int getDoc_id() {
        return doc_id;
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

    /**
     * @return the medID
     */
    public String getSpecialization() {
        return specialization;
    }

    
    private int doc_id;
    private int u_id;
    private String f_name;
    private String l_name;
    private String m_name;
    private String specialization;
    
    public DocList(int doc_id,int u_id,String f_name,String l_name,String m_name,String specialization){
        this.doc_id=doc_id;
        this.u_id=u_id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.m_name=m_name;
        this.specialization=specialization;
    }
}
