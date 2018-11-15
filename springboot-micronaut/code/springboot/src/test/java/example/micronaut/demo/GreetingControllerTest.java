package example.micronaut.demo;

import org.junit.Test;
//tag::imports[]
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
//end::imports[]

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

//tag::clazz[]
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

	@Autowired
	private WebTestClient webClient;
//end::clazz[]

//tag::invokeApiGreetingWithNameParam[]
	@Test
	public void invokeApiGreetingWithNameParam() {
		this.webClient.get().uri("/api/greeting?name=sergio").exchange().expectStatus().isOk()
				.expectBody(Greeting.class);
	}
//end::invokeApiGreetingWithNameParam[]

	@Test
	public void invokeApiGreetingHiWithNameParam() {
		this.webClient.get().uri("/api/greeting/hi?name=sergio").exchange().expectStatus().isOk()
				.expectBody(Greeting.class)
				.consumeWith(result -> assertEquals("sergio", result.getResponseBody().getContent()));
	}

	@Test
	public void invokeApiGreetingSaluteWithoutNameParamTakesDefaultValue() {
		this.webClient.get().uri("/api/greeting/salute").exchange().expectStatus().isOk()
				.expectBody(Greeting.class)
				.consumeWith(result -> assertEquals("John", result.getResponseBody().getContent()));
	}

	@Test
	public void invokeApiGreetingHiWithoutNameParam() {
		this.webClient.get().uri("/api/greeting/hi").exchange().expectStatus().isOk()
				.expectBody(Greeting.class)
				.consumeWith(result -> assertNull(result.getResponseBody().getContent()));
	}

	@Test
	public void invokeApiGreetingWithoutParam() {
		this.webClient.get().uri("/api/greeting").exchange().expectStatus().isBadRequest();
	}

}
