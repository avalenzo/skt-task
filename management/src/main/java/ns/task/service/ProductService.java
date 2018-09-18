package ns.task.service;

import ns.task.pojo.Product;

import java.util.List;

public interface ProductService {

    String addProduct(Product product);

    List<Product> getAll();
}
