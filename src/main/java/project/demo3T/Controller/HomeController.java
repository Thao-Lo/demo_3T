package project.demo3T.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.demo3T.categoryDAO.CategoryDAO;
import project.demo3T.entity.Category;
import project.demo3T.repository.CategoryRepository;

@Controller
public class HomeController {

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message", "Hello Spring MVC");
		return "welcome";

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
	@Autowired
	private CategoryRepository categoryRepository;
	    @GetMapping("/categories")
	    public String getAllCategories(Model model) {
	    	List<Category> categories = categoryRepository.findAll();
	        model.addAttribute("categories", categories);
	        return "categories";
	    }
}

