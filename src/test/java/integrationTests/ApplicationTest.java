package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import masteryproject.blogplatform.Category;
import masteryproject.blogplatform.CategoryRepository;
import masteryproject.blogplatform.Post;
import masteryproject.blogplatform.PostRepository;
import masteryproject.blogplatform.PostTag;
import masteryproject.blogplatform.TagRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
	
	private void assertThatStatusIsOk(String mapping) throws Exception {
		ResultActions performMockGetRequest = this.mockMvc.perform(get(mapping));
		ResultActions response = performMockGetRequest.andDo(print());
		response.andExpect(status().isOk());
	}

	@Resource
	private MockMvc mockMvc;
	
	@Resource
	private PostRepository postRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository reviewTagRepo;
		
	@Test
	public void postsStatusShouldBeOk() throws Exception {
		assertThatStatusIsOk("/posts");
	}


	
	
 }