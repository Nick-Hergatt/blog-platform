package masteryproject.blogplatform;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category underTest;

	@Before
	public void initialize() {
		underTest = new Category("Ben");

	}
	
	@Test
	public void categorySHouldHaveName() {
		String underTestName = underTest.getCategoryName();
		assertThat(underTestName, is("Ben"));
	}
	
}
