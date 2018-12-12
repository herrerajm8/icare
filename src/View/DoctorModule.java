/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import hms2.Login.CoR_LoginDoctor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.User;
import hms2.Sng_Back;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Leo James
 */
public class DoctorModule extends javax.swing.JFrame {

    
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Integer> idList1 = new ArrayList<>();
    
    
    
    
    /**
     * Creates new form DoctorModule
     */
    public DoctorModule() {
        initComponents();
        show_user();
        show_user1();
    }
    PatientData pData= new PatientData();
    PatientData1 pData1= new PatientData1();
    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            String query1="SELECT * FROM patientrec WHERE assignedDoctor IS NULL";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            
            User user;
            while(rs.next()){
                user=new User(rs.getInt("patientID"),rs.getInt("assignedDoctor"),rs.getString("patient_FirstName"),rs.getString("patient_LastName"),rs.getString("patient_MI"),rs.getString("diagnosis"),rs.getString("patient_Address"),rs.getInt("patient_Age"),rs.getString("gender"),rs.getInt("room_No"),rs.getDate("date_Admitted"));
                usersList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return usersList;
    }
     public ArrayList<User> userList1(){
        ArrayList<User> userList1 = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
             int usrid = CoR_LoginDoctor.instance().getId();
            System.out.println(usrid);
            String query2="SELECT * FROM patientrec JOIN doctors ON assignedDoctor = doctor_id WHERE user_id ="+usrid;
            
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(query2);
            
            User user;
            while(rs2.next()){
                user=new User(rs2.getInt("patientID"),rs2.getInt("assignedDoctor"),rs2.getString("patient_FirstName"),rs2.getString("patient_LastName"),rs2.getString("patient_MI"),rs2.getString("diagnosis"),rs2.getString("patient_Address"),rs2.getInt("patient_Age"),rs2.getString("gender"),rs2.getInt("room_No"),rs2.getDate("date_Admitted"));
                userList1.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return userList1;
    }
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)jTableAvailable.getModel();
        Object[] row = new Object[10];
        model.setRowCount(0);
        for(int i=0; i<list.size();i++){
            row[0]=list.get(i).getpatient_LastName();
            row[1]=list.get(i).getpatient_FirstName();
            row[2]=list.get(i).getpatient_MI();
            row[3]=list.get(i).getdiagnosis();
            row[4]=list.get(i).getpatient_Address();
            row[5]=list.get(i).getpatient_Age();
            row[6]=list.get(i).getgender();
            row[7]=list.get(i).getroom_No();
            row[8]=list.get(i).getdate_Admitted();
            idList.add(i, list.get(i).getpatientID());
            model.addRow(row);
        }
    }
    public void show_user1(){
        ArrayList<User> list1 = userList1();
        DefaultTableModel model = (DefaultTableModel)jTableAcc.getModel();
        Object[] row = new Object[10];
        model.setRowCount(0);
        for(int i=0; i<list1.size();i++){
            row[0]=list1.get(i).getpatient_LastName();
            row[1]=list1.get(i).getpatient_FirstName();
            row[2]=list1.get(i).getpatient_MI();
            row[3]=list1.get(i).getdiagnosis();
            row[4]=list1.get(i).getpatient_Address();
            row[5]=list1.get(i).getpatient_Age();
            row[6]=list1.get(i).getgender();
            row[7]=list1.get(i).getroom_No();
            row[8]=list1.get(i).getdate_Admitted();
            idList1.add(i, list1.get(i).getpatientID());
            model.addRow(row);
        }
    }
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAvailable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAcc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jTableAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LastName", "FirstName", "MI", "Diagnosis", "Adress", "Age", "Gender", "Room", "Admitted"
            }
        ));
        jTableAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAvailableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAvailable);
        if (jTableAvailable.getColumnModel().getColumnCount() > 0) {
            jTableAvailable.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTableAvailable.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTableAvailable.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTableAvailable.getColumnModel().getColumn(3).setPreferredWidth(190);
            jTableAvailable.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTableAvailable.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        jTabbedPane1.addTab("Available Patients", jScrollPane1);

        jTableAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LastName", "FirstsName", "MI", "Diagnosis", "Address", "Age", "Gender", "Room", "Admitted"
            }
        ));
        jTableAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAcc);
        if (jTableAcc.getColumnModel().getColumnCount() > 0) {
            jTableAcc.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableAcc.getColumnModel().getColumn(3).setPreferredWidth(190);
        }

        jTabbedPane1.addTab("Accepted Patients", jScrollPane2);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 10, 730, 410);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication10/img/adminbg1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAvailableMouseClicked
        // TODO add your handling code here:
        int index = jTableAvailable.getSelectedRow();
        TableModel model = jTableAvailable.getModel();
        String lastName = model.getValueAt(index,0).toString();
        String firstName = model.getValueAt(index,1).toString();
        String mName = model.getValueAt(index,2).toString();
        String diag = model.getValueAt(index,3).toString();
        String address = model.getValueAt(index,4).toString();
        String age = model.getValueAt(index,5).toString();
        String gender = model.getValueAt(index,6).toString();
        String room = model.getValueAt(index,7).toString();
        String admit = model.getValueAt(index,8).toString();
        close();
        pData.setVisible(true);
        Sng_Back.instance().setPreviousPage(this);
        pData.pack();
        pData.setLocationRelativeTo(null);
        pData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pData.lname.setText(lastName);
        pData.fname.setText(firstName);
        pData.mname.setText(mName);
        pData.diagnosis.setText(diag);
        pData.jTextAddress.setText(address);
        pData.jTextAge.setText(age);
        pData.jTextGender.setText(gender);
        pData.jTextRoom.setText(room);
        pData.jTextAdmitted.setText(admit);
        pData.setId(idList.get(index));
    }//GEN-LAST:event_jTableAvailableMouseClicked

    private void jTableAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAccMouseClicked
        // TODO add your handling code here:
        int index = jTableAcc.getSelectedRow();
        TableModel model = jTableAcc.getModel();
        String lastName = model.getValueAt(index,0).toString();
        String firstName = model.getValueAt(index,1).toString();
        String mName = model.getValueAt(index,2).toString();
        String diag = model.getValueAt(index,3).toString();
        String address = model.getValueAt(index,4).toString();
        String age = model.getValueAt(index,5).toString();
        String gender = model.getValueAt(index,6).toString();
        String room = model.getValueAt(index,7).toString();
        String admit = model.getValueAt(index,8).toString();
        
        close();
        Sng_Back.instance().setPreviousPage(this);
        pData1.setVisible(true);
        pData1.pack();
        pData1.setLocationRelativeTo(null);
        pData1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pData1.lname.setText(lastName);
        pData1.fname.setText(firstName);
        pData1.mname.setText(mName);
        pData1.diagnosis.setText(diag);
        pData1.jTextAddress.setText(address);
        pData1.jTextAge.setText(age);
        pData1.jTextGender.setText(gender);
        pData1.jTextRoom.setText(room);
        pData1.jTextAdmitted.setText(admit);
        pData1.setId(idList1.get(index));
    }//GEN-LAST:event_jTableAccMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableAcc;
    public javax.swing.JTable jTableAvailable;
    // End of variables declaration//GEN-END:variables
}
