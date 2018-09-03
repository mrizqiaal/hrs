package hotelreservationsystem;
import java.io.File;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static java.time.Instant.now;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Receptionist extends javax.swing.JFrame {
    Connection conn = null;
    Statement idguest = null, room = null, guestst = null, roomst = null, reservationst = null;
    public Receptionist() {
        initComponents();
        this.setLocationRelativeTo(null);
        checkin.setDate(new Date());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guestname = new javax.swing.JTextField();
        guestemail = new javax.swing.JTextField();
        guestphone = new javax.swing.JTextField();
        roomtype = new javax.swing.JComboBox<>();
        roomnumber = new javax.swing.JTextField();
        roomprice = new javax.swing.JTextField();
        checkin = new com.toedter.calendar.JDateChooser();
        checkout = new com.toedter.calendar.JDateChooser();
        submit = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        available = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        guestaddress = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guestname.setBackground(new java.awt.Color(95, 206, 202));
        guestname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        guestname.setForeground(new java.awt.Color(255, 255, 255));
        guestname.setBorder(null);
        getContentPane().add(guestname, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 91, 273, 32));

        guestemail.setBackground(new java.awt.Color(95, 206, 202));
        guestemail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        guestemail.setForeground(new java.awt.Color(255, 255, 255));
        guestemail.setBorder(null);
        getContentPane().add(guestemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 139, 273, 32));

        guestphone.setBackground(new java.awt.Color(95, 206, 202));
        guestphone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        guestphone.setForeground(new java.awt.Color(255, 255, 255));
        guestphone.setBorder(null);
        getContentPane().add(guestphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 178, 273, 32));
        guestphone.getAccessibleContext().setAccessibleDescription("");

        roomtype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Room", "Double Room", "Family Room" }));
        roomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypeActionPerformed(evt);
            }
        });
        getContentPane().add(roomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 93, 123, 30));

        roomnumber.setEditable(false);
        roomnumber.setBackground(new java.awt.Color(95, 206, 202));
        roomnumber.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        roomnumber.setForeground(new java.awt.Color(255, 255, 255));
        roomnumber.setBorder(null);
        getContentPane().add(roomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 181, 127, 29));

        roomprice.setEditable(false);
        roomprice.setBackground(new java.awt.Color(95, 206, 202));
        roomprice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        roomprice.setForeground(new java.awt.Color(255, 255, 255));
        roomprice.setBorder(null);
        getContentPane().add(roomprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 138, 127, 29));

        checkin.setBackground(new java.awt.Color(95, 206, 202));
        checkin.setForeground(new java.awt.Color(255, 255, 255));
        checkin.setDateFormatString("yyyy-MM-dd");
        checkin.setEnabled(false);
        checkin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 226, 127, 29));

        checkout.setBackground(new java.awt.Color(95, 206, 202));
        checkout.setDateFormatString("yyyy-MM-dd");
        checkout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 127, 32));

        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 313, 150, 60));

        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 313, 160, 60));

        available.setBorder(null);
        available.setContentAreaFilled(false);
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });
        getContentPane().add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 150, 50));

        guestaddress.setBackground(new java.awt.Color(95, 206, 202));
        guestaddress.setColumns(20);
        guestaddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guestaddress.setForeground(new java.awt.Color(255, 255, 255));
        guestaddress.setLineWrap(true);
        guestaddress.setRows(4);
        guestaddress.setTabSize(1);
        guestaddress.setCaretColor(new java.awt.Color(95, 206, 202));
        guestaddress.setDisabledTextColor(new java.awt.Color(95, 206, 202));
        guestaddress.setSelectionColor(new java.awt.Color(95, 206, 202));
        jScrollPane1.setViewportView(guestaddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 270, 94));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Receptionist.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String checkin_date = ((JTextField)checkin.getDateEditor().getUiComponent()).getText();
        String checkout_date = ((JTextField)checkout.getDateEditor().getUiComponent()).getText();
        int type = roomtype.getSelectedIndex(), numberroom = 0, id = 0;
        String typeroom, idroom;
        if (type==0) {
            typeroom = "Single Room";
            idroom = "S";
        } else if (type==1) {
            typeroom = "Double Room";
            idroom = "D";
        } else {
            typeroom = "Family Room";
            idroom = "F";
        }
        conn = MySqlConnect.ConnectDB();
        try {
            room = conn.createStatement();
            room.executeQuery("Select min(roomnumber) from room where roomtype='"+typeroom+"' and roomstatus='Available'");
            ResultSet rs = room.getResultSet();
            if (rs.next())
                numberroom = rs.getInt(1);
            idguest = conn.createStatement();
            idguest.executeQuery("Select max(guestid) from guest");
            ResultSet rs2 = idguest.getResultSet();
            if (rs2.next())
                id = rs2.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
        if((numberroom+1)%100<10){
            idroom+="0";
        }else{
            idroom+="";
        }
        if (guestname.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Name is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } else if (guestemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"E-mail is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } else if (guestphone.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Phone is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } else if (guestaddress.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Address is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } else if (checkin_date.equals("") || checkout_date.equals("")) {
            JOptionPane.showMessageDialog(null,"Date is required.", "Invalid Information", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                Date date_checkin = date.parse(checkin_date);
                Date date_checkout = date.parse(checkout_date);
                int selisih = (int)TimeUnit.MILLISECONDS.toDays(date_checkout.getTime() - date_checkin.getTime());
                if(selisih > 0) {
                   try {
                        String guestq = "Insert into guest(guestname, guestemail, guestphone, guestaddress) values ('"+guestname.getText()+"','"+guestemail.getText()+"','"+guestphone.getText()+"','"+guestaddress.getText()+"')";
                        String roomq = "Update room set roomstatus='Unavailable' where roomid = '"+idroom+(numberroom%100)+"'";
                        String resq = "Insert into reservation values('"+(id+1)+"','"+idroom+(numberroom%100)+"','"+checkin_date+"','"+checkout_date+"')";
                        guestst = conn.createStatement();
                        guestst.executeUpdate(guestq);
                        roomst = conn.createStatement();
                        roomst.executeUpdate(roomq);
                        reservationst = conn.createStatement();
                        reservationst.executeUpdate(resq);
                        JOptionPane.showMessageDialog(null,"Room has been succesfully reserved.", "Reservation Complete", JOptionPane.INFORMATION_MESSAGE);
                        Receptionist2 r = new Receptionist2();
                        r.setVisible(true);
                        this.dispose();
                        JasperReport jasrep;
                        JasperPrint jaspri;
                        JasperDesign jasdes;
                        try {
                            File report = new File("src/hotelreservationsystem/receipt.jrxml");
                            jasdes = JRXmlLoader.load(report);
                            jasrep = JasperCompileManager.compileReport(jasdes);
                            jaspri = JasperFillManager.fillReport(jasrep, null, MySqlConnect.ConnectDB());
                            JasperViewer.viewReport(jaspri, false);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Jasper Report error.", "System Error", JOptionPane.ERROR_MESSAGE);
                        }
                   } catch (SQLException e) {
                       JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
                   }
                } else {
                    JOptionPane.showMessageDialog(null, "Date did not match!", "Date Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void roomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomtypeActionPerformed
        conn = MySqlConnect.ConnectDB();
        int type = roomtype.getSelectedIndex(), numberroom = 0;
        double priceroom;
        String typeroom, idroom;
        if (type==0) {
            typeroom = "Single Room";
            priceroom = 275000;
            idroom = "S";
        } else if (type==1) {
            typeroom = "Double Room";
            priceroom = 350000;
            idroom = "D";
        } else {
            typeroom = "Family Room";
            priceroom = 475000;
            idroom = "F";
        }
        try {
            room = conn.createStatement();
            room.executeQuery("Select min(roomnumber) from room where roomtype='"+typeroom+"' and roomstatus='Available'");
            ResultSet rs = room.getResultSet();
            if (rs.next())
                numberroom = rs.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Syntax Error!", "System Error", JOptionPane.ERROR_MESSAGE);
        }
        if((numberroom+1)%100<10){
            idroom+="0";
        }else{
            idroom+="";
        }
        if (numberroom==0) {
            roomnumber.setText(" -");
            roomprice.setText(" -");
        } else {
            roomnumber.setText(""+numberroom);
            roomprice.setText(""+priceroom);
        }  
    }//GEN-LAST:event_roomtypeActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        Receptionist2 r2 = new Receptionist2();
        r2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_availableActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton available;
    private com.toedter.calendar.JDateChooser checkin;
    private com.toedter.calendar.JDateChooser checkout;
    private javax.swing.JTextArea guestaddress;
    private javax.swing.JTextField guestemail;
    private javax.swing.JTextField guestname;
    private javax.swing.JTextField guestphone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField roomnumber;
    private javax.swing.JTextField roomprice;
    private javax.swing.JComboBox<String> roomtype;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
