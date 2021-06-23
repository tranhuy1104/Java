package jdbcrework2;

import java.sql.*;

public class UpdateResultSetDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=bank";
        Connection conn= DriverManager.getConnection(url,"sa","sa");
        System.out.println(conn);
        PreparedStatement prst=conn.prepareStatement("select * from person",
        ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=prst.executeQuery();
        if (rs.absolute(2)){
            rs.updateString(2,"chien");
            rs.updateRow();
            System.out.println("thanh cong");
        }
        //xoa
        
        }
       /** //them moi
        rs.moveToInsertRow();
        rs.updateString(2,"quang");
        rs.insertRow();
        //quay lai dong trupc do
        rs.moveToCurrentRow();
        rs.close();
        prst.close();
        conn.close();*/
    }

