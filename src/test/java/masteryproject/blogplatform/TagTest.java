package masteryproject.blogplatform;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TagTest {

		Tag underTest;

		@Before
		public void initialize() {
			underTest = new Tag("Country");

		}
		
		@Test
		public void categorySHouldHaveName() {
			String underTestName = underTest.getTagName();
			assertThat(underTestName, is("Country"));
		}
		
	}

