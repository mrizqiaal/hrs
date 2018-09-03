package hotelreservationsystem;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Admin extends javax.swing.JFrame {
    Connection conn = null;
    Statement st = null,  st2 = null;

    public Admin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xroomid = new javax.swing.JTextField();
        xroomnumber = new javax.swing.JTextField();
        xroomtype = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xroomid.setEditable(false);
        xroomid.setBackground(new java.awt.Color(95, 206, 202));
        xroomid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        xroomid.setForeground(new java.awt.Color(255, 255, 255));
        xroomid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        xroomid.setBorder(null);
        getContentPane().add(xroomid, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 217, 60, 30));

        xroomnumber.setEditable(false);
        xroomnumber.setBackground(new java.awt.Color(95, 206, 202));
        xroomnumber.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        xroomnumber.setForeground(new java.awt.Color(255, 255, 255));
        xroomnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        xroomnumber.setBorder(null);
        getContentPane().add(xroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 298, 50, 30));

        xroomtype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        xroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Family" }));
        xroomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xroomtypeActionPerformed(evt);
            }
        });
        getContentPane().add(xroomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 136, 145, 30));

        submit.setToolTipText("");
        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 133, 150, 40));

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 203, 150, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        conn = MySqlConnect.ConnectDB();
        int type = xroomtype.getSelectedIndex(), roomnumber = 0, num = 0;
        double roomprice;
        String roomtype, sql, roomid;
        if (type==0) {
            roomtype = "Single Room";
            roomprice = 275000;
            num = 2;
            roomid = "S";
        } else if (type==1) {
            roomtype = "Double Room";
            roomprice = 350000;
            num = 3;
            roomid = "D";
        } else {
            roomtype = "Family Room";
            roomprice = 475000;
            num = 4;
            roomid = "F";
        }
        try {
            st = conn.createStatement();
            st.executeQuery("Select max(roomnumber) from room where roomnumber like '"+num+"%'");
            ResultSet rs = st.getResultSet();
            if (rs.next())
                roomnumber = rs.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error.", "System Error", JOptionPane.ERROR_MESSAGE);
        }
        if((roomnumber+1)%100<10){
            roomid+="0";
        }else{
            roomid+="";
        }
        sql = "Insert into room values ('"+roomid+((roomnumber+1)%100)+"','"+(roomnumber+1)+"','"+roomtype+"','"+roomprice+"','Available')";
        try {
            st2 = conn.createStatement();
            st2.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Available Room has been succesfully updated.", "Update Complete", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error.", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void xroomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xroomtypeActionPerformed
        conn = MySqlConnect.ConnectDB();
        int type = xroomtype.getSelectedIndex(), roomnumber = 0, num = 0;
        double roomprice;
        String roomtype, roomid;
        if (type==0) {
            roomtype = "Single Room";
            roomprice = 275000;
            num = 2;
            roomid = "S";
        } else if (type==1) {
            roomtype = "Double Room";
            roomprice = 350000;
            num = 3;
            roomid = "D";
        } else {
            roomtype = "Family Room";
            roomprice = 475000;
            num = 4;
            roomid = "F";
        }
        try {
            st = conn.createStatement();
            st.executeQuery("Select max(roomnumber) from room where roomnumber like '"+num+"%'");
            ResultSet rs = st.getResultSet();
            if (rs.next())
                roomnumber = rs.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error.", "System Error", JOptionPane.ERROR_MESSAGE);
        }
        if((roomnumber+1)%100<10){
            roomid+="0";
        }else{
            roomid+="";
        }
        xroomid.setText(roomid+((roomnumber+1)%100));
        xroomnumber.setText(""+(roomnumber+1));
    }//GEN-LAST:event_xroomtypeActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logout;
    private javax.swing.JButton submit;
    private javax.swing.JTextField xroomid;
    private javax.swing.JTextField xroomnumber;
    private javax.swing.JComboBox<String> xroomtype;
    // End of variables declaration//GEN-END:variables
}
