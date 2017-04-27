package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion conexion = null;
    //Gestional la conexion con la base de datos
    private Connection connection = null;

    private Conexion() {
        try {
            //1. Cargar el Driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //2. Obtener la conexion
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecanariño", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }

}
