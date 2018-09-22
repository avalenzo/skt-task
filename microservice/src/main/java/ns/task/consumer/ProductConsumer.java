package ns.task.consumer;

import ns.task.config.RabbitConfig;
import ns.task.model.Product;
import ns.task.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);


    private ProductService productService;

    @Autowired
    public ProductConsumer(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_ADD_PRODUCT)
    public Product addProductListener(Product product) {
        Product productSaved = new Product();

        logger.info("Consumer: Product request received: {}", product);
        try {
            productSaved = productService.addProduct(product);
        } catch (Exception e) {
            logger.error("Error", e);
        }

        return productSaved;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_GET_PRODUCTS)
    public List<Product> getProductsListener() {
        List<Product> products = new ArrayList<>();

        logger.info("Consumer: List request received");
        try {
            products = productService.getAllProducts();
        } catch (Exception e) {
            logger.error("Error retrieving products", e);
        }

        return products;
    }
}
