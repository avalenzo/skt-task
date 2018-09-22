package ns.task.controller.products;

import ns.task.model.Product;
import ns.task.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String getAll(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);

        return "productList";
    }

    @GetMapping(value = "/product")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());

        return "product";
    }

    @PostMapping(value = "/product")
    public String addProduct(ModelMap model, @ModelAttribute("product") Product product) {
        model.addAttribute("newProduct", product);

        productService.addProduct(product);
        return "productConfirm";
    }


}
