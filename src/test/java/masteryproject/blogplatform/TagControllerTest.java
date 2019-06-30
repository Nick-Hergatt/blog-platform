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


public class TagControllerTest {
	@InjectMocks
	private TagController underTest;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private PostTag tag1;
	
	@Mock
	private PostTag tag2;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetAllTags() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("tagsTemplate"));
	}
	
	@Test
	public void shouldHaveTagsInModel() {
		Collection<PostTag> postTags = Arrays.asList(tag1, tag2);
		Mockito.when(tagRepo.findAll()).thenReturn(postTags);
		underTest.findAll(model);
		verify(model).addAttribute("tagsAttribute", postTags);
	}
	
	@Test
	public void shouldBeAbleToGet1Tag() {
		Optional<PostTag> tag1Optional = Optional.of(tag1);
		Mockito.when(tagRepo.findById(0L)).thenReturn(tag1Optional);
		underTest.getTag(0L, model);
		verify(model).addAttribute("tagAttribute", tag1);
	}
	
	
}
