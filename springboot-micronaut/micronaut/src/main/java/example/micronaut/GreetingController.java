package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicLong;

@Controller("/api")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Get("/greeting{?name}")
    public Greeting greeting(String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }

    @Get("/hi{?name}")
    public Greeting hi(@Nullable String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }

    @Get("/greeting/salute")
    public Greeting salute(@Nullable String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }
}
