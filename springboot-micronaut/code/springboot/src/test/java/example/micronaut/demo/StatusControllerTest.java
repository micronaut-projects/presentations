package example.micronaut.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatusControllerTest {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void invokeHttpStatusReturns201() {
		this.webClient.get().uri("/httpstatus").exchange().expectStatus().isCreated();
	}
}
