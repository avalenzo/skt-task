package ns.task.service;

import ns.task.model.Product;
import ns.task.producer.ProductProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductProducer producer;
    private static final Logger logger = LoggerFactory.getLogger(ProductProducer.class);

    public ProductServiceImpl(ProductProducer producer) {
        this.producer = producer;
    }

    @Override
    public Product addProduct(Product product) {
        try {
            product = producer.sendProduct(product);
        } catch (Exception e) {
            logger.error("Error sending the product:", e);
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        return producer.requestProducts();
    }
}
