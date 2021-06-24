package FinalExam.db;
import FinalExam.entity.Contact;
import java.sql.*;
import java.util.*;
public class ContactAccessor {

    public void insert(Contact contact) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Connector connector = new Connector();
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement("Insert into contact values (?,?,?,?)");
            preparedStatement.setString(1,contact.getContactName());
            preparedStatement.setString(2,contact.getCompany());
            preparedStatement.setString(3,contact.getEmail());
            preparedStatement.setString(4,contact.getPhone());
            preparedStatement.executeUpdate();
        }finally {
            Connector.close(preparedStatement);
            Connector.close(connection);
        }
    }

    public List<Contact> getByName(String contactName) throws Exception{
        List<Contact> reValue = new ArrayList<Contact>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Connector connector = new Connector();
            connection = connector.getConnection();
            String sql = " Select * from contact where contactName = ?";
            if(contactName != null && !contactName.equals("")){
                sql += " where contactName like'" + contactName+"'";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,contactName);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String Name = resultSet.getString(1);
                String dbCompany = resultSet.getString(2);
                String dbEmail = resultSet.getString(3);
                String dbPhone = resultSet.getString(4);
                Contact contact = new Contact();
                  contact.setContactName(Name);
                  contact.setCompany(dbCompany);
                  contact.setEmail(dbEmail);
                  contact.setPhone(dbPhone);
                  reValue.add(contact);
            }
        }finally {
            Connector.close(resultSet);
            Connector.close(preparedStatement);
            Connector.close(connection);
        }
        return  reValue;
    }

    public List<Contact> getContacts(String contactName) throws Exception{
        List<Contact> reValue = new ArrayList<Contact>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Connector connector = new Connector();
            connection = connector.getConnection();
            String sql = "Select * from contact";
            if(contactName != null && !contactName.equals("")){
                sql+= " where contactName like '" +contactName+"'";
            }
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String dbName = resultSet.getString(1);
                String dbCompany = resultSet.getString(2);
                String dbEmail = resultSet.getString(3);
                String dbPhone = resultSet.getString(4);
                Contact contact = new Contact();
                   contact.setContactName(dbName);
                   contact.setCompany(dbCompany);
                   contact.setEmail(dbEmail);
                   contact.setPhone(dbPhone);
                   reValue.add(contact);
            }
        }finally {
            Connector.close(resultSet);
            Connector.close(preparedStatement);
            Connector.close(connection);
        }
        return reValue;
    }
}
