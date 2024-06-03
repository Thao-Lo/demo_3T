package project.demo3T.Controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.demo3T.entity.Category;
import project.demo3T.entity.Product;
import project.demo3T.repository.CategoryRepository;
import project.demo3T.repository.ProductRepository;

@Controller
public class HomeController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRespository;

	@GetMapping("/")
	public String getAllProducts(@RequestParam(required = false) Long categoryId,
			@RequestParam(required = false) String action, Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Product> products;

		if ("SHOW_PRODUCT_BY_CATEGORY".equals(action) && categoryId != 0) {
            products = productRespository.findByCategoryId(categoryId);
        }  else if (("SHOW_ALL").equals(action)) {
			products = productRespository.findAll();
		} else {
			products = productRespository.findAll();
		}		 
		System.out.println(products.get(0).getName());
		
		model.addAttribute("allCategory", categories);
		model.addAttribute("products", products);
//		System.out.println(categories);
		return "index";
	}
		 

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello from another JSP file!");
		return "hello";
	}

	@GetMapping("/welcomes")
	@ResponseBody
	public String welcomes() {
		return "I'm tired Hello Thao Lo";
	}

//	@GetMapping("/")
//	public String welcome(Model model) {	
//		return "index";
//
//	}	

//	    @GetMapping("/categories")
//	    public String getAllCategories(Model model) {
//	    	List<Category> categories = categoryRepository.findAll();
//	        model.addAttribute("categories", categories);
//	        return "categories";
//	    }
}
