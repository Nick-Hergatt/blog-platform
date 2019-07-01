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
	
	@Resource
	private AuthorRepository authorRepo;

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
	public String addPost(String title, String content, String category, String author, String postTag) {

		Post postToAdd = new Post(title, content);
		postRepo.save(postToAdd);

		Category categoryToAdd = new Category(category);
		if (categoryRepo.findByName(categoryToAdd.getName()) == null) {
			categoryRepo.save(categoryToAdd);
		}
		
		postRepo.findById(postToAdd.getId()).get().addCategory(categoryRepo.findByName(categoryToAdd.getName()));

		
		postTag.replace(" ", "");
		String[] postTags = postTag.split(",");
		for (String tagToAdd : postTags) {
			PostTag postTagToAdd = new PostTag(tagToAdd);
			if (tagRepo.findByName(postTagToAdd.getName()) == null) {
				tagRepo.save(postTagToAdd);
			}
			postRepo.findById(postToAdd.getId()).get().addPostTag(tagRepo.findByName(postTagToAdd.getName()));
		}
		
		Author authorAdding = new Author(author);
		if (authorRepo.findByName(authorAdding.getName()) == null) {
			authorRepo.save(authorAdding);
		}
		postRepo.findById(postToAdd.getId()).get().addAuthor(authorAdding);
		
		postRepo.save(postRepo.findById(postToAdd.getId()).get());

		return "redirect:/posts";
	}

}
