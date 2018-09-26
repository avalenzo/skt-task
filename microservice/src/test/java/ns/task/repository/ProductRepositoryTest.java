package ns.task.repository;

import ns.task.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setCode("CODE001");
        product.setName("PRODUCT001");
        product.setPrice(BigDecimal.ONE);

        Long id = productRepository.addProduct(product.getCode(), product.getName(), product.getPrice());
        assertThat(id).isNotNull();
    }

    @Test
    public void getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("CODE001", "PRODUCT001", BigDecimal.ONE);
        Product product2 = new Product("CODE002", "PRODUCT002", BigDecimal.valueOf(2));
        products.add(product1);
        products.add(product2);

        for(Product p : products) {
            productRepository.addProduct(p.getCode(), p.getName(), p.getPrice());
        }

        List<Product> productsSaved = productRepository.getAllProducts();
        assertThat(productsSaved).isNotNull();
        assertThat(productsSaved.get(0).getCode()).isNotNull();
    }
}