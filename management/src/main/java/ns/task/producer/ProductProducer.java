package ns.task.producer;

import ns.task.config.RabbitConfig;
import ns.task.pojo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProducer {

    private static final Logger logger = LoggerFactory.getLogger(ProductProducer.class);
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendProduct(Product product) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_PRODUCTS, RabbitConfig.ROUTING_KEY_ADD_PRODUCT, product);
        logger.info("Producer: Product '{}' was sent", product.getCode());
    }

    public List<Product> requestProducts() {
        Object products = rabbitTemplate.convertSendAndReceive(RabbitConfig.EXCHANGE_PRODUCTS, RabbitConfig.ROUTING_KEY_GET_PRODUCTS, "list");
        logger.info("Producer: List of Products was requested");

        return (List<Product>) products;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_ADD_PRODUCT)
    public void addProductListener(Product product) {
        logger.info("Product received: {}", product );
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_GET_PRODUCTS)
    public void getProductsListener() {
        logger.info("ListRequest Received");
    }




}
