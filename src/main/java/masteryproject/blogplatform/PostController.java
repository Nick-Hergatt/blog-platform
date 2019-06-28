import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/posts/", "/posts" })
public class PostController {

	@Resource
	private PostRepository postRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository reviewTagRepo;

	@RequestMapping({ "", "/" })
	public String findAll(Model model) {
		model.addAttribute("reviewsAttribute", postRepo.findAll());
		return "reviewsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String getReview(@PathVariable("id") Long id, Model model) {
		model.addAttribute("reviewAttribute", postRepo.findById(id).get());
		return "reviewTemplate";
	}

	@PostMapping({ "/add-post", "/add-post/" })
	public String addReview(String title, String content, String category, String tag) {

		Post postToAdd = new Post(title, content);
		postRepo.save(postToAdd);

		Category categoryToAdd = new Category(category);
		if (categoryRepo.findByName(categoryToAdd.getName()) == null) {
			categoryRepo.save(categoryToAdd);
		}
		
		postRepo.findById(postToAdd.getId()).get().addCategory(categoryRepo.findByName(categoryToAdd.getName()));

		tag.replace(" ", "");
		String[] reviewTags = tag.split(",");
		for (String tagToAdd : reviewTags) {
			Tag TagToAdd = new Tag(tagToAdd);
			if (reviewTagRepo.findByName(tagToAdd.getName()) == null) {
				reviewTagRepo.save(tagToAdd);
			}
			postRepo.findById(postToAdd.getId()).get().addReviewTag(reviewTagRepo.findByName(tagToAdd.getName()));
		}
		
		
		postRepo.save(postRepo.findById(postToAdd.getId()).get());

		return "redirect:/all-reviews";
	}

}
