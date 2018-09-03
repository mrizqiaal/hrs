package hotelreservationsystem;
import java.sql.*;
import javax.swing.*;

public class Login extends javax.swing.JFrame {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userid = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        userpass = new javax.swing.JPasswordField();
        cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userid.setBackground(new java.awt.Color(95, 206, 202));
        userid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userid.setForeground(new java.awt.Color(255, 255, 255));
        userid.setBorder(null);
        getContentPane().add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 165, 330, 30));

        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 130, 60));

        userpass.setBackground(new java.awt.Color(95, 206, 202));
        userpass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userpass.setForeground(new java.awt.Color(255, 255, 255));
        userpass.setBorder(null);
        getContentPane().add(userpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 330, 30));

        cancel.setBorder(null);
        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        conn = MySqlConnect.ConnectDB();
        String sql = "Select * from user where userid='"+userid.getText()+"' and userpass='"+userpass.getText()+"'";
        try {
            st = conn.createStatement();
            if (userid.getText().equals("")&&userpass.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Login information required.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } else if (userid.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"ID cannot be blank.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } else if (userpass.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Password cannot be blank.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                rs = st.executeQuery(sql);
                if (rs.next()){
                    JOptionPane.showMessageDialog(null,"You have logged in successfully.", "Login Successfull", JOptionPane.INFORMATION_MESSAGE);
                    if (userid.getText().equals("admin")&&userpass.getText().equals("admin")) {
                        Admin a= new Admin();
                        a.setVisible(true);
                    } else if (userid.getText().equals("manager")&&userpass.getText().equals("manager")) {
                        Manager m= new Manager();
                        m.setVisible(true);
                    } else {
                        Receptionist2 r = new Receptionist2();
                        r.setVisible(true);
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password!", "Access Denied", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton submit;
    private javax.swing.JTextField userid;
    private javax.swing.JPasswordField userpass;
    // End of variables declaration//GEN-END:variables
}
