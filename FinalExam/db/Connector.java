package FinalExam.db;
import java.sql.*;
public class Connector {

    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/contact";
        String username = "";
        String password = "";
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try{
                preparedStatement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static  void close(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
