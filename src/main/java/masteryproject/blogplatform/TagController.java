package masteryproject.blogplatform;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/all-Tags", "/all-Tags/"})
public class TagController {
	
	@Autowired
	private TagRepository reviewTagRepo;
	
	@Resource
	private PostRepository reviewRepo;
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("reviewTagsAttribute", reviewTagRepo.findAll());
		return "reviewTagsTemplate";
	}
	
	@RequestMapping({"/{id}","/{id}/"})
	public String getTag(@PathVariable("id")Long id, Model model) {
		model.addAttribute("reviewTagAttribute", reviewTagRepo.findById(id).get());
		return "reviewTagTemplate";
	}
	
	@PostMapping({"add-reviewTag", "add-reviewTag/"})
	public String addReviewTag(String name) {
		Tag reviewTagToAdd = new Tag(name);
		if (reviewTagRepo.findByName(reviewTagToAdd.getName()) == null) {
	            reviewTagRepo.save(reviewTagToAdd);
	        }	
		return "redirect:/all-reviewTags";
	}
}
