package hotelreservationsystem;
import java.sql.*;
import javax.swing.*;

public class SignUp extends javax.swing.JFrame {
    Connection conn = null;
    Statement st = null;
    public SignUp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userid = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        userpass = new javax.swing.JPasswordField();
        useremail = new javax.swing.JTextField();
        usergender = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        userconfirmpass = new javax.swing.JPasswordField();
        cancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userid.setBackground(new java.awt.Color(95, 206, 202));
        userid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userid.setForeground(new java.awt.Color(255, 255, 255));
        userid.setBorder(null);
        getContentPane().add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 98, 230, 30));

        username.setBackground(new java.awt.Color(95, 206, 202));
        username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 96, 270, 30));

        userpass.setBackground(new java.awt.Color(95, 206, 202));
        userpass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userpass.setForeground(new java.awt.Color(255, 255, 255));
        userpass.setBorder(null);
        getContentPane().add(userpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 151, 230, 30));

        useremail.setBackground(new java.awt.Color(95, 206, 202));
        useremail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        useremail.setForeground(new java.awt.Color(255, 255, 255));
        useremail.setBorder(null);
        getContentPane().add(useremail, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 151, 270, 30));

        usergender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usergender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        usergender.setToolTipText("");
        getContentPane().add(usergender, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 205, 120, 30));

        submit.setToolTipText("");
        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 283, 150, 50));

        userconfirmpass.setBackground(new java.awt.Color(95, 206, 202));
        userconfirmpass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userconfirmpass.setForeground(new java.awt.Color(255, 255, 255));
        userconfirmpass.setBorder(null);
        getContentPane().add(userconfirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 206, 230, 30));

        cancel.setBorder(null);
        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SignUp.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        conn = MySqlConnect.ConnectDB();
        int gender = usergender.getSelectedIndex();
        char usergender;
        if (gender == 0)
            usergender = 'L';
        else
            usergender = 'P';
        String sql = "Insert into user values('"+userid.getText()+"', '"+userpass.getText()+"', '"+username.getText()+"', '"+useremail.getText()+"','"+usergender+"')";
        try {
            st = conn.createStatement();
            if (userid.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"ID is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            } else if (userpass.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Password is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            } else if (userconfirmpass.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Confirm Password is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            } else if (!userpass.getText().equalsIgnoreCase(userconfirmpass.getText())) {
                JOptionPane.showMessageDialog(null,"Confirm Password did not match!", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            }else if (username.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Name is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            } else if (useremail.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"E-mail is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"You have successfully registered.", "Registration Successfull", JOptionPane.INFORMATION_MESSAGE);
                Homepage h = new Homepage();
                h.setVisible(true);
                this.dispose();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ID is already in use.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_submitActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton submit;
    private javax.swing.JPasswordField userconfirmpass;
    private javax.swing.JTextField useremail;
    private javax.swing.JComboBox<String> usergender;
    private javax.swing.JTextField userid;
    private javax.swing.JTextField username;
    private javax.swing.JPasswordField userpass;
    // End of variables declaration//GEN-END:variables
}
