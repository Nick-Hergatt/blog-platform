package masteryproject.blogplatform;

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
	private TagRepository tagRepo;

	@RequestMapping({ "", "/" })
	public String findAll(Model model) {
		model.addAttribute("postsAttribute", postRepo.findAll());
		return "postsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String getPost(@PathVariable("id") Long id, Model model) {
		model.addAttribute("postAttribute", postRepo.findById(id).get());
		return "postTemplate";
	}

	@PostMapping({ "/add-post", "/add-post/" })
	public String addPost(String title, String content, String category, String tag) {

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
			PostTag addingTag = new PostTag(tagToAdd);
			if (tagRepo.findByName(addingTag.getName()) == null) {
				tagRepo.save(addingTag);
			}
			postRepo.findById(postToAdd.getId()).get().addTag(tagRepo.findByName(addingTag.getName()));
		}
		
		
		postRepo.save(postRepo.findById(postToAdd.getId()).get());

		return "redirect:/all-reviews";
	}

}
