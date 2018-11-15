package example.micronaut;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicLong;

//tag::imports[]
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
//end::imports[]

//tag::clazz[]
@Controller("/api")
public class GreetingController {
//end::clazz[]

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //tag::urlparams[]
    @Get("/greeting{?name}")
    public Greeting greeting(String name) {
    //end::urlparams[]
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
