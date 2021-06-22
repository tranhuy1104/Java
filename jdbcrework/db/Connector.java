package jdbcrework.db;
import java.sql.*;
import java.util.*;

public class Connector {
    public Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        String url = "jdbc:sqlserver://localhost:1433;databaseName = bank";
        String username = "sa";
        String password = "sa";
        return DriverManager.getConnection(url,username,password);
    }
    public static void close (ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (Exception e){

            }
        }
    }
    public static void close (PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try{
                preparedStatement.close();
            }catch(Exception ex){

            }
        }
    }
    public static void close(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch(Exception ex){

            }
        }
    }
}
