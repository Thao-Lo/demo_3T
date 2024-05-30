package project.demo3T.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo3T.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	//entity class + datatype of Id
	
}
