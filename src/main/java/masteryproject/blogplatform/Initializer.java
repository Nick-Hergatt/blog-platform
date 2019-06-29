package masteryproject.blogplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Initializer implements CommandLineRunner {
	@Autowired
	private PostRepository postRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private TagRepository tagRepo;
	
	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category("drinking");
		categoryRepo.save(category1);

		Category category2 = new Category("Programming");
		categoryRepo.save(category2);

		Category category3 = new Category("Literature");
		categoryRepo.save(category3);

		Tag tag1 = new Tag("Sci-fi");
		tagRepo.save(tag1);

		Tag tag2 = new Tag("High Street");
		tagRepo.save(tag2);
		
		Tag tag3 = new Tag("Java");
		tagRepo.save(tag3);
		
		Post post1 = new Post("OOP", "This is an intriguing article about OOP");
		postRepo.save(post1);
		
		Post post2 = new Post("Bar in columbus", "Review of a bar on high street");
		postRepo.save(post2);
		
		Post post3 = new Post("Dune", "Critical look at Frank Herberts Dune");
		postRepo.save(post3);
		
		Author author1 = new Author("Nick Hergatt");
		authorRepo.save(author1);
		
		Author author2 = new Author("Brandon Cox");
		authorRepo.save(author2);
		
		Author author3 = new Author("Ben Williams");
		authorRepo.save(author3);
		
		post1.addCategory(category2);
		post1.addTag(tag3);
		post1.addAuthor(author1);
		postRepo.save(post1);
		
		post2.addCategory(category1);
		post2.addTag(tag2);
		post2.addAuthor(author2);
		postRepo.save(post2);
		
		post3.addCategory(category3);
		post3.addTag(tag1);
		post3.addAuthor(author3);
		postRepo.save(post3);
		
		
		
		
	

		
	}

}