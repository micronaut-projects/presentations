package example.micronaut;

import java.util.List;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BookControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {  server.stop(); }
        if (client != null) {  client.stop(); }
    }

    @Test
    public void invokeApiBookWithNameParam() {
        HttpRequest request = HttpRequest.GET("/api/books/1491950358");
        Book book = client.toBlocking().retrieve(request, Book.class);
        assertNotNull(book);
    }

    @Test
    public void invokeApiBooks() {
        HttpRequest request = HttpRequest.GET("/api/books");
        Argument arg = Argument.of(List.class, Book.class);
        HttpResponse<List<Book>> response = client.toBlocking().exchange(request, arg);
        assertEquals(HttpStatus.OK, response.status());
        assertTrue(response.getHeaders().contains(HttpHeaders.WARNING));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void invokeApiBookWithoutParam() {
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.NOT_FOUND))));
        client.toBlocking().exchange(HttpRequest.GET("/api/books/12356789"), Boolean.class);
    }

    @Test
    public void invokeApiBookSaveWithoutPayload() {
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.BAD_REQUEST))));
        HttpRequest req = HttpRequest.POST("/api/books", new Book("", ""));
        client.toBlocking().exchange(req, Book.class);
    }

    @Test
    public void invokeApiBookExHandlesCustomException() {
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.NOT_FOUND))));
        HttpRequest req = HttpRequest.GET("/api/books/ex");
        client.toBlocking().retrieve(req);
    }

}