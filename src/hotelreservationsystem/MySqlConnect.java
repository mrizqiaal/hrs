package hotelreservationsystem;
import java.sql.*;
import javax.swing.JOptionPane;

public class MySqlConnect {
    public static Connection ConnectDB(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbhotelsystem","root","");
            return conn;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cannot Connect to Database Server.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
}
