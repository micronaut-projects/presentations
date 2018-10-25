package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

public class GreetingControllerTest {

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
    public void invokeApiGreetingWithNameParam() {
        HttpRequest request = HttpRequest.GET("/api/greeting?name=sergio");
        Greeting greeting = client.toBlocking().retrieve(request, Greeting.class);
        assertNotNull(greeting);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void invokeApiGreetingWithoutParam() {
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.BAD_REQUEST))));
        client.toBlocking().exchange(HttpRequest.GET("/api/greeting"), Greeting.class);
    }

    @Test
    public void invokeApiGreetingHiWithoutParam() {
        HttpRequest request = HttpRequest.GET("/api/hi");
        Greeting greeting = client.toBlocking().retrieve(request, Greeting.class);
        assertNotNull(greeting);
        assertNull(greeting.getContent());
    }

    @Test
    public void invokeApiGreetingHiWithParam() {
        HttpRequest request = HttpRequest.GET("/api/hi?name=sergio");
        Greeting greeting = client.toBlocking().retrieve(request, Greeting.class);
        assertNotNull(greeting);
        assertEquals("sergio", greeting.getContent());
    }

}