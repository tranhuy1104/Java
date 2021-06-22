package jdbcrework.db;
import com.example.jdbcadvance.entity.Person;
import  jdbcrework.entity.Person;
import java.util.*;
import java.sql.*;
public class PersonAccessor {
    public void insert(Person p) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(" Insert into Persons values (?)");
            preparedStatement.setString(1,p.getName());
            preparedStatement.executeUpdate();
        }finally {
            Connector.close(preparedStatement);
            Connector.close(conn);
        }
    }

    public void delete(int id) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement("delete * from Persons where id =?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }finally {
            Connector.close(preparedStatement);
            Connector.close(conn);
        }
    }

    public void update(Person p) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement("update Persons set name = ? where id = ?");
            preparedStatement.setString(1,p.getName());
            preparedStatement.setInt(2,p.getId());
            preparedStatement.executeUpdate();
        }finally {
            Connector.close(preparedStatement);
            Connector.close(conn);
        }
    }

    public void findByPrimaryKey(int id) throws Exception{
        Person retValue = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            String sql = " select * from Persons where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String dbName = resultSet.getString(2);
                retValue = new Person();
                retValue.setId(id);
                retValue.setName(dbName);
            }
        }finally {
            Connector.close(resultSet);
            Connector.close(preparedStatement);
            Connector.close(conn);
        }
        return retValue;
    }

    public List<Person> getPersons(String name) throws Exception{
        List<Person> retValue = new ArrayList<Person>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            String sql = " select * from Persons";
            if(name!=null && !name.equals("")){
                sql += " where name like '"+name+"'";
            }
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String dbName = resultSet.getString(2);
                Person p = new Person();
                p.setId(id);
                p.setName(dbName);
                retValue.add(p);
            }
        }finally {
            Connector.close(resultSet);
            Connector.close(preparedStatement);
            Connector.close(conn);
        }
        return retValue;
    }
}
