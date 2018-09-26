package ns.task.service;

import ns.task.model.Product;
import ns.task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        Long id = productRepository.addProduct(product.getCode(), product.getName(), product.getPrice());
        product.setId(id);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
