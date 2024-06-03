package project.demo3T.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.demo3T.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "SELECT p.id,p.name,p.price, p.category_id FROM product p JOIN category c ON p.category_id = c.id WHERE c.id = :categoryId", nativeQuery = true)
	List<Product> findProductByCategoryId(@Param("categoryId") int categoryId);
	
	List<Product> findByCategoryId (Long categoryId);
}
