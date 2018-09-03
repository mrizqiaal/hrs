package hotelreservationsystem;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Manager2 extends javax.swing.JFrame {
    private Object[][] dataTable = null;
    private String[] header = {"RoomID","Number","Type","Price","Status"};
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public Manager2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        reportroom = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        report = new javax.swing.JButton();
        guest = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        reportroom.setEnabled(false);
        reportroom.getTableHeader().setReorderingAllowed(false);
        reportroom.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                reportroomAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(reportroom);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 670, 210));

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 150, 60));

        report.setBorder(null);
        report.setContentAreaFilled(false);
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        getContentPane().add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 150, 50));

        guest.setBorder(null);
        guest.setContentAreaFilled(false);
        guest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestActionPerformed(evt);
            }
        });
        getContentPane().add(guest, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 140, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Manager2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void reportroomAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reportroomAncestorAdded
        conn = MySqlConnect.ConnectDB();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("Select * from room");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount(), row = 0;
            while(rs.next()) {
                row = rs.getRow();
            }
            dataTable = new Object[row][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                dataTable[x][0] = rs.getString("roomid");
                dataTable[x][1] = rs.getInt("roomnumber");
                dataTable[x][2] = rs.getString("roomtype");
                dataTable[x][3] = rs.getDouble("roomprice");
                dataTable[x][4] = rs.getString("roomstatus");
                x++;
            }
            reportroom.setModel(new DefaultTableModel(dataTable,header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reportroomAncestorAdded

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        Manager m = new Manager();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportActionPerformed

    private void guestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestActionPerformed
        Manager3 m3 = new Manager3();
        m3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_guestActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton guest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JButton report;
    private javax.swing.JTable reportroom;
    // End of variables declaration//GEN-END:variables
}
