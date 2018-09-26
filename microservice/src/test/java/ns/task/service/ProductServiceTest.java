package ns.task.service;

import ns.task.model.Product;
import ns.task.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
public class ProductServiceTest {

    @Autowired
    @InjectMocks
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setId(2L);
        product.setName("PRODUCT DUMMY");
        product.setCode("DCODE003");
        product.setPrice(BigDecimal.valueOf(100L));

        when(productRepository.addProduct(product.getCode(), product.getName(), product.getPrice()))
                .thenReturn(2L);

        Product productSaved = productService.addProduct(product);
        assertThat(productSaved).isNotNull();
        assertThat(productSaved.getId()).isNotNull();
        assertThat(productSaved.getCode()).isEqualTo(product.getCode());
    }

    @Test
    public void getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("CODE001", "PRODUCT001", BigDecimal.ONE);
        Product product2 = new Product("CODE002", "PRODUCT002", BigDecimal.valueOf(2));

        products.add(product1);
        products.add(product2);

        when(productRepository.getAllProducts()).thenReturn(products);

        List<Product> productsRetrieved = productService.getAllProducts();
        assertThat(productsRetrieved).isNotNull();
        assertThat(productsRetrieved).hasSize(2);
    }
}