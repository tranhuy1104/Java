package com.example.jdbcadv.db;

import com.example.jdbcadv.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonAccessor {

    public void insert(Person p) throws Exception{
        Connection conn = null;
        PreparedStatement prst = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            prst = conn.prepareStatement("insert into persons values(?)");
            prst.setString(1,p.getName());
            prst.executeUpdate();
        }finally {
            Connector.close(prst);
            Connector.close(conn);
        }
    }
    public void delete(int id) throws Exception{
        Connection conn = null;
        PreparedStatement prst = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            prst = conn.prepareStatement("delete from persons where id =?");
            prst.setInt(1,id);
            prst.executeUpdate();
        }finally {
            Connector.close(prst);
            Connector.close(conn);
        }
    }
    public void update(Person p) throws Exception{
        Connection conn = null;
        PreparedStatement prst = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            prst = conn.prepareStatement("update persons set name =? where id =?");
            prst.setString(1,p.getName());
            prst.setInt(2,p.getId());
            prst.executeUpdate();
        }finally {
            Connector.close(prst);
            Connector.close(conn);
        }

    }
    public Person findByPrimaryKey(int id) throws Exception{
        Person retValue = null;
        Connection conn = null;
        PreparedStatement prst = null;
        ResultSet rs = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            String sql = "select * from persons where id =?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            rs = prst.executeQuery();
            if(rs.next()){
                String dbName = rs.getString(2);
                retValue = new Person();
                retValue.setId(id);
                retValue.setName(dbName);
            }

        }finally {
            Connector.close(rs);
            Connector.close(prst);
            Connector.close(conn);
        }

        return retValue;
    }
    public List<Person> getPersons(String name) throws Exception{
        List<Person> retValue = new ArrayList<Person>();
        Connection conn = null;
        PreparedStatement prst = null;
        ResultSet rs = null;
        try{
            Connector connector = new Connector();
            conn = connector.getConnection();
            String sql = "select * from persons";
            if(name!=null && !name.equals("")){
                sql += "where name like '"+name+"'";
            }
            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String dbName = rs.getString(2);
                Person p = new Person();
                p.setId(id);
                p.setName(dbName);
                retValue.add(p);
            }
        }finally {
            Connector.close(rs);
            Connector.close(prst);
            Connector.close(conn);
        }
        return retValue;
    }
}
