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


}
