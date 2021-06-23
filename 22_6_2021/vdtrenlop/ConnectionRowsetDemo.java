package jdbcrework2;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.concurrent.locks.Condition;

public class ConnectionRowsetDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/bank";
        Connection conn=  DriverManager.getConnection(url,"root","");
        System.out.println(conn);
        PreparedStatement prst=conn.prepareStatement("select * from person",
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=prst.executeQuery();

        //create connected rowset
        JdbcRowSetImpl rowSet =new JdbcRowSetImpl(rs);
        boolean b=rowSet.next();
        if (b){
            String name=rowSet.getString(2);
            System.out.println("name:" + name);

        }
        b=false;
        b=rowSet.relative(3);
        if (b){
            System.out.println("Gia tir tinh 3 ong tu dong dau tien");
            String name = rowSet.getString(2);
            System.out.println("Name " +name);
        }
        //cap nhat du lieu:luu y :da de resultset type la scrollable va updatable
        //them moi du lieu
        rowSet.moveToInsertRow();
        rowSet.updateString(2,"FPT");
        rowSet.updateRow();
        rowSet.insertRow();
        rowSet.moveToCurrentRow();


        rs.close();
        conn.close();
    }
}
