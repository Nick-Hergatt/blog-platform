package integrationTests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@Resource
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	String endpoint;

	private void assertThatEndPointIsOk(String endpoint) {
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);
		HttpStatus status = response.getStatusCode();
		status.is2xxSuccessful();
	}

	
}
