package masteryproject.blogplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/categories/", "/categories"})
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;


	@RequestMapping({ "/", "" })
	public String findAll(Model model) {
		model.addAttribute("categoriesAttribute", categoryRepo.findAll());
		return "categoriesTemplate";

	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String getCategory(@PathVariable Long id, Model model) {
		model.addAttribute("categoryAttribute", categoryRepo.findById(id));
		return "categoryTemplate";
	}

	@PostMapping({ "/categories-add", "/categories-add/" })
	public String AddCategory(String name) {
		Category categoryToAdd = new Category(name);
		if (categoryRepo.findByName(categoryToAdd.getName()) == null) {
			categoryRepo.save(categoryToAdd);
		}
		return "redirect:/categories";
	}

}