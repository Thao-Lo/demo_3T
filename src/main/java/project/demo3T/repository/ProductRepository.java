package project.demo3T.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.demo3T.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
