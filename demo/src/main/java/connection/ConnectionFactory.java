package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final Logger LOGGER= Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/schooldb?useSSL=false";
    private static final String USER="root";
    private static final String PASS="alexandra";



    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Problema la incarcarea clasei de conexiuni!");

        }
    }



    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nu s-a putut face conexiunea!");
        }
        return con;
    }



    public static void close(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problema la inchiderea conexiunii!");
            }
        }
    }



    public static void close(Statement s) {
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problema la statemment!");
            }
        }
    }



    public static void close(ResultSet r) {
        if (r != null) {
            try {
                r.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problema la inchiderea r");
            }
        }
    }

}