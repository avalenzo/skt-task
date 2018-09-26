package ns.task.consumer;

import ns.task.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductConsumerTest {

    @Autowired
    @InjectMocks
    private ProductConsumer productConsumer;

    @Test
    public void addProductListener() {
        Product product = new Product();
        product.setCode("CODELIST01");
        product.setName("NAMELIST01");
        product.setPrice(BigDecimal.ONE);

        Product productConsumed = productConsumer.addProductListener(product);
        assertThat(productConsumed).isNotNull();
        assertThat(productConsumed.getId()).isNotNull();
        assertThat(productConsumed.getCode()).isEqualTo(product.getCode());

    }

    @Test
    public void getProductsListener() {
        Product product = new Product();
        product.setCode("CODELIST02");
        product.setName("NAMELIST02");
        product.setPrice(BigDecimal.ONE);

        Product productConsumed = productConsumer.addProductListener(product);
        List<Product> products = productConsumer.getProductsListener();
        assertThat(products).isNotNull();
    }
}