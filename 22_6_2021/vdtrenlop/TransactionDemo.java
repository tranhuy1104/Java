package jdbcrework2;

import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName = bank";
        Connection conn= DriverManager.getConnection(url,"sa","sa");
        System.out.println(conn);
        //begin transaction
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("select * from person");
        if (rs.next()){

            System.out.println(rs.getString(2));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
