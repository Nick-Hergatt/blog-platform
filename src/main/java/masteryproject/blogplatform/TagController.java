package masteryproject.blogplatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/tags", "/tags/"})
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("tagsAttribute", tagRepo.findAll());
		return "postTagsTemplate";
	}
	
	@RequestMapping({"/{id}","/{id}/"})
	public String getTag(@PathVariable("id")Long id, Model model) {
		model.addAttribute("tagAttribute", tagRepo.findById(id).get());
		return "postTagTemplate";
	}
	
	@PostMapping({"/tags-add", "/tags-add/"})
	public String addTag(String name) {
		PostTag tagToAdd = new PostTag(name);
		if (tagRepo.findByName(tagToAdd.getName()) == null) {
	            tagRepo.save(tagToAdd);
	        }	
		return "redirect:/tags";
	}
	}
