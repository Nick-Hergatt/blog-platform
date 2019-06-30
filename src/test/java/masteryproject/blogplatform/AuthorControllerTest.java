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

public class AuthorControllerTest {
	@InjectMocks
	private AuthorController underTest;
	
	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private Author author1;
	
	@Mock
	private Author author2;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetAllAuthors() {
		String authors = underTest.findAll(model);
		assertThat(authors, is("authorsTemplate"));
	}
	
	@Test
	public void shouldHaveAuthorsInModel() {
		Collection<Author> Authors = Arrays.asList(author1, author2);
		Mockito.when(authorRepo.findAll()).thenReturn(Authors);
		underTest.findAll(model);
		verify(model).addAttribute("authorsAttribute", Authors);
	}
	
	@Test
	public void shouldBeAbleToGet1Author() {
		Optional<Author> author1Optional = Optional.of(author1);
		Mockito.when(authorRepo.findById(0L)).thenReturn(author1Optional);
		underTest.getAuthor(0L, model);
		verify(model).addAttribute("authorAttribute", author1);
	}
}
