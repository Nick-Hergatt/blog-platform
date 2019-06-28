package masteryproject.blogplatform;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
	
	Author underTest;

	@Before
	public void initialize() {
		underTest = new Author("Ben");

	}
	
	@Test
	public void authorSHouldHaveName() {
		String underTestName = underTest.getName();
		assertThat(underTestName, is("Ben"));
	}
	
}
