package ns.task.producer;

import ns.task.config.RabbitConfig;
import ns.task.pojo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProducer {

    private static final Logger logger = LoggerFactory.getLogger(ProductProducer.class);
    private RabbitTemplate rabbitTemplate;

    public ProductProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Product sendProduct(Product product) {
        Object productSaved = rabbitTemplate.convertSendAndReceive(RabbitConfig.EXCHANGE_PRODUCTS, RabbitConfig.ROUTING_KEY_ADD_PRODUCT, product);
        logger.info("Producer: Product '{}' was sent", product.getCode());

        return (Product) productSaved;
    }

    public List<Product> requestProducts() {
        Object products = rabbitTemplate.convertSendAndReceive(RabbitConfig.EXCHANGE_PRODUCTS, RabbitConfig.ROUTING_KEY_GET_PRODUCTS, "list");
        logger.info("Producer: List of Products was requested");

        return (List<Product>) products;
    }


}
