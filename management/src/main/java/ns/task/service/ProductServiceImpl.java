package ns.task.service;

import ns.task.pojo.Product;
import ns.task.producer.ProductProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductProducer producer;

    public ProductServiceImpl(ProductProducer producer) {
        this.producer = producer;
    }

    @Override
    public Product addProduct(Product product) {
        return producer.sendProduct(product);
    }

    @Override
    public List<Product> getAll() {
        return producer.requestProducts();
    }
}
