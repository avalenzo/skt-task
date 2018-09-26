package ns.task.controller.products;

import ns.task.model.Product;
import ns.task.producer.ProductProducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ProductProducer producer;

    private MockMvc mock;

    @Before
    public void init() {
        this.mock = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void getAll() throws Exception {
        mock.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"));
    }

    @Test
    public void newProduct() throws Exception {
        mock.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(view().name("createProduct"));
    }

    @Test
    public void addProduct() throws Exception {
        Product product = new Product("CODETEST", "PNAME", BigDecimal.TEN);
        mock.perform(post("/product").content(product.toString()))
                .andExpect(status().isOk());
    }
}