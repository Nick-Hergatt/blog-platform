package integrationTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import masteryproject.blogplatform.Author;
import masteryproject.blogplatform.AuthorRepository;
import masteryproject.blogplatform.Category;
import masteryproject.blogplatform.CategoryRepository;
import masteryproject.blogplatform.Post;
import masteryproject.blogplatform.PostRepository;
import masteryproject.blogplatform.PostTag;
import masteryproject.blogplatform.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebLayerTest {
	
	@Autowired
	ObjectMapper objectMapper;

	@Resource
	private MockMvc mockMvc;

	@MockBean
	private PostRepository postRepo;

	@MockBean
	private CategoryRepository categoryRepo;
	
	@MockBean
	private TagRepository tagRepo;
	
	@MockBean
	private AuthorRepository authorRepo;
	
	@Mock
	private PostTag Tag;

	@Mock
	private Category category;

	@Mock
	private Post post;

	@Mock
	private Author author;

	
	@Test
	public void shouldReturnAllAuthors() throws Exception {
		this.mockMvc.perform(get("/authors")).andDo(print()).andExpect(status().isOk());

	}
	
	@Test
	public void shouldReturnAuthor1Page() throws Exception {
		Optional<Author> authorOptional = Optional.of(author);
		Mockito.when(authorRepo.findById(1L)).thenReturn(authorOptional);
		this.mockMvc.perform(get("/authors/1")).andDo(print()).andExpect(status().isOk());
	}

//	@Test
//	public void shouldReturnReview1Page() throws Exception {
//		Optional<Post> post1Optional = Optional.of(post1);
//		Mockito.when(postRepo.findById(1L)).thenReturn(post1Optional);
//		Mockito.when(post1.getCategory()).thenReturn(category);
//		this.mockMvc.perform(get("/all-reviews/1")).andDo(print()).andExpect(status().isOk());
//	}
//
//	@Test
//	public void shouldReturnReview2Page() throws Exception {
//		Optional<Review> reviewOptional = Optional.of(review2);
//		when(postRepo.findById(2L)).thenReturn(reviewOptional);
//		when(post2.getCategory()).thenReturn(category);
//		this.mockMvc.perform(get("/all-reviews/2")).andDo(print()).andExpect(status().isOk());
//	}
//
//
//
//	@Test
//	public void shouldReturnAllCategoriesPage() throws Exception {
//		this.mockMvc.perform(get("/all-categories")).andDo(print()).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void shouldReturnSingleCategoryPage() throws Exception {
//		Optional<Category> categoryOptional = Optional.of(category);
//		when(categoryRepo.findById(category.getId())).thenReturn(categoryOptional);
//		when(category.getName()).thenReturn("Category Name");
//		this.mockMvc.perform(get("/all-categories/" + category.getId().toString())).andDo(print()).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void shouldAddCategory() throws Exception {
//		Category categoryToAdd = new Category("");
//		mockMvc.perform(post("/all-categories/add-category").contentType(MediaType.APPLICATION_JSON).content(toJson(categoryToAdd)))
//		.andExpect(status().is3xxRedirection());
//	}
//	@Test
//	public void shouldReturnAllTagsPage() throws Exception {
//		this.mockMvc.perform(get("/all-reviewTags")).andDo(print()).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void shouldAddReviewTag() throws Exception {
//		PostTag reviewTagToAdd = new ReviewTag("");
//		mockMvc.perform(post("/all-reviewTags/add-reviewTag").contentType(MediaType.APPLICATION_JSON).content(toJson(reviewTagToAdd)))
//			.andExpect(status().is3xxRedirection());
//	}
//	
//	private String toJson(Review reviewToAdd) {
//		// learn to make this work in 2 weeks
//		return reviewToAdd.getTitle();
//	}
//	
//	private String toJson(Category category) {
//		return category.getName();
//	}
//	
//	private String toJson(ReviewTag reviewTag) {
//		return reviewTag.getName();
//	}
}
