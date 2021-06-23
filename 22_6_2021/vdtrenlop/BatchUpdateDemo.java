package jdbcrework2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/bank";
        Connection conn= DriverManager.getConnection(url,"root","");
        System.out.println(conn);
        Statement st=conn.createStatement();
        for (int i=0;i<10;i++){
            st.addBatch("insert  into person value ('id','name')");
            //execute Batch
            st.executeBatch();
            st.close();
            conn.close();
        }
    }
}
