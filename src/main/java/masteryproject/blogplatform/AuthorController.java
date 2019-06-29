package masteryproject.blogplatform;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/author", "/author/"})
public class AuthorController {
	
	@Autowired
	private PostRepository postRepo;
	
	@Resource
	private AuthorRepository authorRepo;
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("reviewTagsAttribute", authorRepo.findAll());
		return "reviewTagsTemplate";
	}
	
	@RequestMapping({"/{id}","/{id}/"})
	public String getTag(@PathVariable("id")Long id, Model model) {
		model.addAttribute("reviewTagAttribute", authorRepo.findById(id).get());
		return "reviewTagTemplate";
	}
	
	@PostMapping({"add-author", "add-author/"})
	public String addAuthor(String name) {
		Author authorAdding = new Author(name);
		if (authorRepo.findByName(authorAdding.getName()) == null) {
			authorRepo.save(authorAdding);
	        }	
		return "redirect:/author";
	}
}