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

public class CategoryControllerTest {
	@InjectMocks
	private CategoryController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category1;
	
	@Mock
	private Category category2;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetAllCategories() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("categoriesTemplate"));
	}
	
	@Test
	public void shouldHaveCategoriesInModel() {
		Collection<Category> categories = Arrays.asList(category1, category2);
		Mockito.when(categoryRepo.findAll()).thenReturn(categories);
		underTest.findAll(model);
		verify(model).addAttribute("categoriesAttribute", categories);
	}
	
	@Test
	public void shouldBeAbleToGet1Category() {
		Optional<Category> category1Optional = Optional.of(category1);
		Mockito.when(categoryRepo.findById(0L)).thenReturn(category1Optional);
		underTest.getCategory(0L, model);
		verify(model).addAttribute("categoryAttribute", category1Optional);
	}
}
