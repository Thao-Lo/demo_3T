package project.demo3T.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.demo3T.entity.Category;
import project.demo3T.entity.Product;
import project.demo3T.repository.CategoryRepository;
import project.demo3T.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRespository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/product")
	public String showForm(Product product, Model model) {
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("allCategory", category);
		return "product";
	}

	@PostMapping("/product")
	public String addNewProduct(@RequestParam("productName") String name, @RequestParam("price") double price,
			@RequestParam("categoryId") Long category_id, @RequestParam("imageData") MultipartFile file) {
		try {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setImageName(file.getOriginalFilename());
			product.setImageData(file.getBytes());			
			product.setCreatedBy("Thao");
		    Category category = categoryRepository.findById(category_id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id"));
	        product.setCategory(category);
			productRespository.save(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";

	}
}
