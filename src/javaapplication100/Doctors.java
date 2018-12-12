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
@Table(name = "doctors", catalog = "icaredb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d")
    , @NamedQuery(name = "Doctors.findByDoctorId", query = "SELECT d FROM Doctors d WHERE d.doctorId = :doctorId")
    , @NamedQuery(name = "Doctors.findByDoctorFname", query = "SELECT d FROM Doctors d WHERE d.doctorFname = :doctorFname")
    , @NamedQuery(name = "Doctors.findByDoctorLname", query = "SELECT d FROM Doctors d WHERE d.doctorLname = :doctorLname")
    , @NamedQuery(name = "Doctors.findByDoctorMi", query = "SELECT d FROM Doctors d WHERE d.doctorMi = :doctorMi")
    , @NamedQuery(name = "Doctors.findBySpecialization", query = "SELECT d FROM Doctors d WHERE d.specialization = :specialization")
    , @NamedQuery(name = "Doctors.findByUserId", query = "SELECT d FROM Doctors d WHERE d.userId = :userId")})
public class Doctors implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "doctor_fname")
    private String doctorFname;
    @Basic(optional = false)
    @Column(name = "doctor_lname")
    private String doctorLname;
    @Column(name = "doctor_mi")
    private String doctorMi;
    @Basic(optional = false)
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "user_id")
    private Integer userId;

    public Doctors() {
    }

    public Doctors(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctors(Integer doctorId, String doctorFname, String doctorLname, String specialization) {
        this.doctorId = doctorId;
        this.doctorFname = doctorFname;
        this.doctorLname = doctorLname;
        this.specialization = specialization;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        Integer oldDoctorId = this.doctorId;
        this.doctorId = doctorId;
        changeSupport.firePropertyChange("doctorId", oldDoctorId, doctorId);
    }

    public String getDoctorFname() {
        return doctorFname;
    }

    public void setDoctorFname(String doctorFname) {
        String oldDoctorFname = this.doctorFname;
        this.doctorFname = doctorFname;
        changeSupport.firePropertyChange("doctorFname", oldDoctorFname, doctorFname);
    }

    public String getDoctorLname() {
        return doctorLname;
    }

    public void setDoctorLname(String doctorLname) {
        String oldDoctorLname = this.doctorLname;
        this.doctorLname = doctorLname;
        changeSupport.firePropertyChange("doctorLname", oldDoctorLname, doctorLname);
    }

    public String getDoctorMi() {
        return doctorMi;
    }

    public void setDoctorMi(String doctorMi) {
        String oldDoctorMi = this.doctorMi;
        this.doctorMi = doctorMi;
        changeSupport.firePropertyChange("doctorMi", oldDoctorMi, doctorMi);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        String oldSpecialization = this.specialization;
        this.specialization = specialization;
        changeSupport.firePropertyChange("specialization", oldSpecialization, specialization);
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
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctors)) {
            return false;
        }
        Doctors other = (Doctors) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication100.Doctors[ doctorId=" + doctorId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
