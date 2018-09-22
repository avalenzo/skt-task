package ns.task.consumer;

import ns.task.config.RabbitConfig;
import ns.task.pojo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ADD_PRODUCT)
    public void addProductListener(Product product) {
        logger.info("Product received: {}", product );
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_GET_PRODUCTS)
    public void getProductsListener() {
        logger.info("ListRequest Received");
    }
}
