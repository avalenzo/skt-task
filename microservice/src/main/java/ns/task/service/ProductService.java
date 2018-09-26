package ns.task.service;

import ns.task.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();
}
