package jdbcrework2;

import java.sql.*;

public class ScrolableResultSetDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databasesName=bank";
        String username="sa";
        String password="sa";
        Connection conn= DriverManager.getConnection(url,username,password);

        PreparedStatement prst=conn.prepareStatement("select * from person",
        ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=prst.executeQuery();
        if (rs.first()){
            System.out.println("name: "+ rs.getString(2));
        }
            if (rs.next()){
                System.out.println("dong tiep theo");
                System.out.println("name: " + rs.getString(2));
            }
        if (rs.previous()){//quay ve truoc
            System.out.println("quay lai dong dau tien");
            System.out.println("name: " + rs.getString(2));
        }
        if (rs.relative(1)){
            System.out.println("2 dong tiep theo");
            System.out.println("name: " + rs.getString(2));
        }
        if (rs.absolute(1)){
            System.out.println("dong so 1");
            System.out.println(rs.getString(2));;
        }
        rs.close();
        prst.close();
        conn.close();
}}
