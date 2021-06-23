package com.example.model;





import com.example.dao.DBConnection;
import com.example.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDao {

    private final Connection conn = DBConnection.createConnection();
    private final String SQL_CREATE_PRODUCT = "INSERT INTO products (productName, productDesc,productPrice) VALUES {?, ?, ?}";
    private final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE Id=?";
    private final String SQL_GET_ALL_PRODUCT = "SELECT * FROM products";
    private final String SQL_UPDATE_PRODUCT = "UPDATE products SET productName=?, productDesc=?,productPrice=? WHERE Id=?";
    private final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE Id=?";

    @Override
    public void createProduct(Product product){
        try(PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_PRODUCT, Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getProductDesc());
            pstmt.setDouble(3, product.getProductPrice());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if (generatedKeys.next()){
                    product.setProductId(generatedKeys.getInt(1));
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
