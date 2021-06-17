package com.example.jdbcadv.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connector {
    public Connection getConnection() throws Exception{
        //1. Register driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        //2. Establish connection
        String url = "jdbc:sqlserver://localhost:1433;databaseName=bank";
        String username = "sa";
        String password ="sa";
        return DriverManager.getConnection(url,username,password);
        //3. Statement:Statement/PreparedStatement/CallAbleStatement
        //4. ResultSet: ke qua tra ve cuar DB(1 hoac nhieu bang)
        //5. Close:ResultSet -> Statement -> Connection
    }
    public static void close(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();

            }catch (Exception e){

            }
        }
    }
    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();

            }catch (Exception e){

            }
        }
    }
    public static void close(Connection connection){
        if(connection!=null){
            try{
                connection.close();

            }catch (Exception e){

            }
        }
    }

}
