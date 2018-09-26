package ns.task.producer;

import ns.task.config.RabbitConfig;
import ns.task.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductProducerTest {

    @Autowired
    @InjectMocks
    private ProductProducer producer;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    private Product product;

    @Test
    public void sendProduct() throws Exception {
        Product product = new Product();
        product.setCode("CODEX001");
        product.setName("DUMMY PRODUCT");
        product.setPrice(BigDecimal.valueOf(7.00));
        product.setId(1L);

        when(rabbitTemplate.convertSendAndReceive(
                RabbitConfig.EXCHANGE_PRODUCT, RabbitConfig.ROUTING_KEY_ADD_PRODUCT, product))
                .thenReturn(product);

        Product productSent = producer.sendProduct(product);
        assertThat(productSent).isNotNull();
        assertThat(productSent.getCode()).isEqualTo(product.getCode());
        assertThat(productSent.getName()).isEqualTo(product.getName());
        assertThat(productSent.getPrice()).isEqualTo(product.getPrice());

    }

    @Test
    public void requestProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setCode("CODEX001");
        product.setName("DUMMY PRODUCT");
        product.setPrice(BigDecimal.valueOf(7.00));
        product.setId(1L);

        products.add(product);

        when(rabbitTemplate.convertSendAndReceive(
                RabbitConfig.EXCHANGE_PRODUCTS, RabbitConfig.ROUTING_KEY_GET_PRODUCTS, ""))
                .thenReturn(products);

        assertThat(products).isNotNull();
        assertThat(products).hasSize(1);
    }
}