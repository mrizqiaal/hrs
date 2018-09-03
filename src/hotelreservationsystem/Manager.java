package hotelreservationsystem;
import java.io.File;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Manager extends javax.swing.JFrame {
    private Object[][] dataTable = null;
    private String[] header = {"GuestID","GuestName","RoomID","Number","Type","CheckIn","CheckOut","Price per night", "Num of Days", "Total"};
    
    Connection conn = null, conn2 = null;
    Statement st = null, st2 = null;
    ResultSet rs = null, rs2 = null;
    public Manager() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        report = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        avail = new javax.swing.JButton();
        guest = new javax.swing.JToggleButton();
        print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GuestID", "GuestName", "RoomID", "Number", "Type", "CheckIn", "CheckOut", "Price per Night", "Num of Days", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        report.setEnabled(false);
        report.getTableHeader().setReorderingAllowed(false);
        report.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                reportAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(report);
        if (report.getColumnModel().getColumnCount() > 0) {
            report.getColumnModel().getColumn(0).setResizable(false);
            report.getColumnModel().getColumn(1).setResizable(false);
            report.getColumnModel().getColumn(2).setResizable(false);
            report.getColumnModel().getColumn(3).setResizable(false);
            report.getColumnModel().getColumn(4).setResizable(false);
            report.getColumnModel().getColumn(5).setResizable(false);
            report.getColumnModel().getColumn(6).setResizable(false);
            report.getColumnModel().getColumn(7).setResizable(false);
            report.getColumnModel().getColumn(8).setResizable(false);
            report.getColumnModel().getColumn(9).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 810, 200));

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 130, 40));

        avail.setBorder(null);
        avail.setContentAreaFilled(false);
        avail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availActionPerformed(evt);
            }
        });
        getContentPane().add(avail, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 315, 120, 50));

        guest.setBorder(null);
        guest.setContentAreaFilled(false);
        guest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestActionPerformed(evt);
            }
        });
        getContentPane().add(guest, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 323, 110, 40));

        print.setBorder(null);
        print.setContentAreaFilled(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 120, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Manager.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void reportAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reportAncestorAdded
        conn = MySqlConnect.ConnectDB();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("Select * from report");
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
                dataTable[x][2] = rs.getString("roomid");
                dataTable[x][3] = rs.getInt("roomnumber");
                dataTable[x][4] = rs.getString("roomtype");
                dataTable[x][5] = rs.getString("checkin_date");
                dataTable[x][6] = rs.getString("checkout_date");
                dataTable[x][7] = rs.getDouble("roomprice");
                dataTable[x][8] = rs.getInt("lama");
                dataTable[x][9] = rs.getDouble("total");
                x++;
            }
            report.setModel(new DefaultTableModel(dataTable,header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reportAncestorAdded

    private void guestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestActionPerformed
        Manager3 m3 = new Manager3();
        m3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_guestActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        JasperReport jasrep;
        JasperPrint jaspri;
        JasperDesign jasdes;
        try {
            File report = new File("src/hotelreservationsystem/report.jrxml");
            jasdes = JRXmlLoader.load(report);
            jasrep = JasperCompileManager.compileReport(jasdes);
            jaspri = JasperFillManager.fillReport(jasrep, null, MySqlConnect.ConnectDB());
            JasperViewer.viewReport(jaspri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Jasper Report error.", "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avail;
    private javax.swing.JToggleButton guest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton print;
    private javax.swing.JTable report;
    // End of variables declaration//GEN-END:variables
}
