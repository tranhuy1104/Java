package com.example.dao;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection createConnection(){
        String dbUrl = "jdbc:derby://localhost:1527//myDB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, "sa", "sa");
        }catch (SQLException ex){
            Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
