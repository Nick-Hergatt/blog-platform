package masteryproject.blogplatform;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;


public class PostControllerTest {
@InjectMocks
	
	private PostController underTest;
	@Mock
	private PostRepository postRepo;
	
	@Mock
	private Post post1;
	
	@Mock
	private Post post2;
	
	@Mock
	Model model;
	

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldBeAbleToGetOnePost() {
		Optional<Post> post1Optional = Optional.of(post1);
		Mockito.when(postRepo.findById(0L)).thenReturn(post1Optional);
		underTest.getPost(0L, model);
		verify(model).addAttribute("postAttribute", post1);
	}


	@Test
	public void shouldHavePostsInModel() {
		Collection<Post> posts = Arrays.asList(post1, post2);
		Mockito.when(postRepo.findAll()).thenReturn(posts);
		underTest.findAll(model);
		verify(model).addAttribute("postsAttribute", posts);
	}
}
