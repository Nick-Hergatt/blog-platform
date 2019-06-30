package masteryproject.blogplatform;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/authors", "/authors/"})
public class AuthorController {

	@Resource
	private AuthorRepository authorRepo;
	

	@RequestMapping({ "/", "" })
	public String findAll(Model model) {
		model.addAttribute("authorsAttribute", authorRepo.findAll());
		return "authorsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String getAuthor(@PathVariable("id") Long id, Model model) {
		model.addAttribute("authorAttribute", authorRepo.findById(id).get());
		return "authorTemplate";
	}

	@PostMapping({ "/add-author", "/add-author/" })
	public String addAuthor(String name) {
		Author authorAdding = new Author(name);
		if (authorRepo.findByName(authorAdding.getName()) == null) {
			authorRepo.save(authorAdding);
		}
		return "redirect:/authors";
	}
}