package hotelreservationsystem;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Manager3 extends javax.swing.JFrame {
    private Object[][] dataTable = null;
    private String[] header = {"ID","Name","E-mail","Phone","Address"};
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public Manager3() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        guest = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        avail = new javax.swing.JButton();
        report = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "E-mail", "Phone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        guest.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        guest.setEnabled(false);
        guest.getTableHeader().setReorderingAllowed(false);
        guest.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                guestAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(guest);
        if (guest.getColumnModel().getColumnCount() > 0) {
            guest.getColumnModel().getColumn(0).setResizable(false);
            guest.getColumnModel().getColumn(1).setResizable(false);
            guest.getColumnModel().getColumn(2).setResizable(false);
            guest.getColumnModel().getColumn(3).setResizable(false);
            guest.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 670, 210));

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 313, 150, 50));

        avail.setBorder(null);
        avail.setContentAreaFilled(false);
        avail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availActionPerformed(evt);
            }
        });
        getContentPane().add(avail, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 130, 60));

        report.setBorder(null);
        report.setContentAreaFilled(false);
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        getContentPane().add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 313, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Manager3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guestAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_guestAncestorAdded
        conn = MySqlConnect.ConnectDB();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("Select * from guest");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount(), row = 0;
            while(rs.next()) {
                row = rs.getRow();
            }
            dataTable = new Object[row][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                dataTable[x][0] = rs.getInt("guestid");
                dataTable[x][1] = rs.getString("guestname");
                dataTable[x][2] = rs.getString("guestemail");
                dataTable[x][3] = rs.getString("guestphone");
                dataTable[x][4] = rs.getString("guestaddress");
                x++;
            }
            guest.setModel(new DefaultTableModel(dataTable,header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guestAncestorAdded

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void availActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availActionPerformed
        Manager2 m2 = new Manager2();
        m2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_availActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        Manager m = new Manager();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avail;
    private javax.swing.JTable guest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logout;
    private javax.swing.JButton report;
    // End of variables declaration//GEN-END:variables
}
