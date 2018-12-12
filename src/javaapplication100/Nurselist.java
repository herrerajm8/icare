/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "nurselist", catalog = "icaredb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Nurselist.findAll", query = "SELECT n FROM Nurselist n")
    , @NamedQuery(name = "Nurselist.findByNurseId", query = "SELECT n FROM Nurselist n WHERE n.nurseId = :nurseId")
    , @NamedQuery(name = "Nurselist.findByNurseFname", query = "SELECT n FROM Nurselist n WHERE n.nurseFname = :nurseFname")
    , @NamedQuery(name = "Nurselist.findByNurseLname", query = "SELECT n FROM Nurselist n WHERE n.nurseLname = :nurseLname")
    , @NamedQuery(name = "Nurselist.findByNurseMi", query = "SELECT n FROM Nurselist n WHERE n.nurseMi = :nurseMi")
    , @NamedQuery(name = "Nurselist.findByUserId", query = "SELECT n FROM Nurselist n WHERE n.userId = :userId")})
public class Nurselist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nurse_id")
    private Integer nurseId;
    @Basic(optional = false)
    @Column(name = "nurse_fname")
    private String nurseFname;
    @Basic(optional = false)
    @Column(name = "nurse_lname")
    private String nurseLname;
    @Column(name = "nurse_mi")
    private String nurseMi;
    @Column(name = "user_id")
    private Integer userId;

    public Nurselist() {
    }

    public Nurselist(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Nurselist(Integer nurseId, String nurseFname, String nurseLname) {
        this.nurseId = nurseId;
        this.nurseFname = nurseFname;
        this.nurseLname = nurseLname;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        Integer oldNurseId = this.nurseId;
        this.nurseId = nurseId;
        changeSupport.firePropertyChange("nurseId", oldNurseId, nurseId);
    }

    public String getNurseFname() {
        return nurseFname;
    }

    public void setNurseFname(String nurseFname) {
        String oldNurseFname = this.nurseFname;
        this.nurseFname = nurseFname;
        changeSupport.firePropertyChange("nurseFname", oldNurseFname, nurseFname);
    }

    public String getNurseLname() {
        return nurseLname;
    }

    public void setNurseLname(String nurseLname) {
        String oldNurseLname = this.nurseLname;
        this.nurseLname = nurseLname;
        changeSupport.firePropertyChange("nurseLname", oldNurseLname, nurseLname);
    }

    public String getNurseMi() {
        return nurseMi;
    }

    public void setNurseMi(String nurseMi) {
        String oldNurseMi = this.nurseMi;
        this.nurseMi = nurseMi;
        changeSupport.firePropertyChange("nurseMi", oldNurseMi, nurseMi);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        Integer oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nurseId != null ? nurseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nurselist)) {
            return false;
        }
        Nurselist other = (Nurselist) object;
        if ((this.nurseId == null && other.nurseId != null) || (this.nurseId != null && !this.nurseId.equals(other.nurseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication100.Nurselist[ nurseId=" + nurseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
