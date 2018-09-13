package ns.task.controller.products;

import com.ns.task.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {


    @GetMapping(value = "/products")
    public String getAll(Model model) {
        List<Product> productList = new ArrayList<>();
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
        model.addAttribute("code", product.getCode());
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());

        return "product";
    }


}
