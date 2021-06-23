package com.example.model;





import com.example.entity.Product;
import java.util.ArrayList;

public class ProductDao {

    public void createProduct(Product product);

    public Product getProductById(int productId);

    public ArrayList<Product> getAllProduct();

    public void updateProduct(Product product);

    public boolean deleteProduct(int productId);
}
