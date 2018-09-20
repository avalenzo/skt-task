package ns.task.repository;

import ns.task.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Procedure
    void addProduct(String code, String name, BigDecimal price);

    @Query(nativeQuery = true, value = "select * from getAllProducts()")
    List<Product> getAllProducts();
}
