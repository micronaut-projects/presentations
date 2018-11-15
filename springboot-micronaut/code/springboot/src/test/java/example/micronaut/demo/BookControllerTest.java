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
public class BookControllerTest {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void invokeApiBooksWithValidIsbn() {
		this.webClient.get().uri("/api/books/1491950358").exchange().expectStatus().isOk()
				.expectBody(Book.class);
	}

	@Test
	public void invokeBooks() {
		this.webClient.get().uri("/api/books").exchange().expectStatus().isOk()
				.expectHeader().exists(HttpHeaders.WARNING);
	}

	@Test
	public void invokeBooksSaveWithInvalidPOJO() {
		this.webClient.post().uri("/api/books")
				.body(BodyInserters.fromObject(new Book("", "new Book")))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	public void invokeApiBooksWithInvalidIsbn() {
		this.webClient.get().uri("/api/books/12356789").exchange().expectStatus().isNotFound();
	}

	@Test
	public void invokeApiBookExHandlesCustomException() {
		this.webClient.get().uri("/api/books/ex").exchange().expectStatus().isNotFound();
	}

}
