package masteryproject.blogplatform;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import masteryproject.intergrationtest.blogplatform.CategoryRepository;


@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private PostRepository postRepo;

	@RequestMapping("/")
	public String findAll(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";

	}

	@RequestMapping("/{name}")
	public String findAllPosts(@PathVariable String name, Model model) {
		model.addAttribute("category", categoryRepo.findByName(name));
		return "category";
	}
	
	@PostMapping("/add")
	public String addPost(String title, String categoryName, String content) {
		Category category = categoryRepo.findByName(categoryName);
		Post newPost = new Post(title, "", category , content);
		postRepo.save(newPost);
		
		return "redirect:/categories/" + categoryName ;
	}
}