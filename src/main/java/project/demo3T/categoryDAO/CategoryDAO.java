package project.demo3T.categoryDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.demo3T.entity.Category;
import project.demo3T.repository.CategoryRepository;

@RestController
public class CategoryDAO {
	
	@Autowired
	private CategoryRepository categoryRepository;

//	@GetMapping("/categories")
//	public List<Category> allCategories() {
//		List<Category> list = categoryRepository.findAll();
//		return list;
//	}

//	@PostMapping("/categories")
//	public Category addCategory(@RequestBody Category category) {
//
//		return categoryRepository.save(category);
//	}
//	@PutMapping("/categories")
//	public Category updateCategory(@RequestBody Category category) {
//
//		return categoryRepository.save(category);
//	}
	
}
