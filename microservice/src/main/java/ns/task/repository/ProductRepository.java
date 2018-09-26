package ns.task.repository;

import ns.task.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from insertProduct(?1, ?2, ?3)", nativeQuery = true)
    Long addProduct(String code, String name, BigDecimal price);

    @Query(value = "select * from getAllProducts()", nativeQuery = true)
    List<Product> getAllProducts();
}
