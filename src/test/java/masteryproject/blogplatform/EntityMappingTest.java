package masteryproject.blogplatform;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private TagRepository tagRepo;

	@Test
	public void shouldSaveandLoadPosts() {
		Post post = new Post("Test", "deep existential Content");
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		Post foundPost = postRepo.findById(post.getId()).get();
		assertThat(foundPost.getTitle(), is("Test"));
	}

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Philosophy");
		entityManager.persist(category);
		entityManager.flush();
		entityManager.clear();
		Category foundCategory = categoryRepo.findById(category.getId()).get();
		assertThat(foundCategory.getName(), is("Philosophy"));
	}
	
	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = new Tag("fries");
		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();
		Tag foundTag = tagRepo.findById(tag.getId()).get();
		assertThat(foundTag.getName(), is("fries"));
		
	}

}