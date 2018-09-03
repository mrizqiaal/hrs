package hotelreservationsystem;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Receptionist2 extends javax.swing.JFrame {
    private Object[][] dataTable = null;
    private String[] header = {"Type","Number","Price"};
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
 
    public Receptionist2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout = new javax.swing.JButton();
        input = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportroom = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 223, 150, 50));

        input.setBorder(null);
        input.setContentAreaFilled(false);
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        getContentPane().add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 146, 150, 50));

        reportroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Number", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (reportroom.getColumnModel().getColumnCount() > 0) {
            reportroom.getColumnModel().getColumn(0).setResizable(false);
            reportroom.getColumnModel().getColumn(1).setResizable(false);
            reportroom.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 460, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Receptionist2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        Receptionist r = new Receptionist();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inputActionPerformed

    private void reportroomAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reportroomAncestorAdded
        conn = MySqlConnect.ConnectDB();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("Select roomtype, roomnumber, roomprice from room where roomstatus = 'Available'");
            ResultSetMetaData meta = rs.getMetaData();
            int col = meta.getColumnCount(), row = 0;
            while(rs.next()) {
                row = rs.getRow();
            }
            dataTable = new Object[row][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                dataTable[x][0] = rs.getString("roomtype");
                dataTable[x][1] = rs.getInt("roomnumber");
                dataTable[x][2] = rs.getDouble("roomprice");
                x++;
            }
            reportroom.setModel(new DefaultTableModel(dataTable,header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reportroomAncestorAdded

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receptionist2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JTable reportroom;
    // End of variables declaration//GEN-END:variables
}
