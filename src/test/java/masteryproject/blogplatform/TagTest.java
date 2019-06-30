package masteryproject.blogplatform;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TagTest {

		PostTag underTest;

		@Before
		public void initialize() {
			underTest = new PostTag("Country");

		}
		
		@Test
		public void categorySHouldHaveName() {
			String underTestName = underTest.getName();
			assertThat(underTestName, is("Country"));
		}
		
	}

