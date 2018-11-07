package example.micronaut.demo;

import java.util.concurrent.atomic.AtomicLong;
//tag::imports[]
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//end::imports[]

//tag::controller[]
@RequestMapping("/api")
@RestController
public class GreetingController {
//end::controller[]

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//tag::get[]
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name") String name) {
//end::get[]
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    //tag::optionalurlvariable[]
    @GetMapping("/greeting/hi")
    public Greeting show(@RequestParam(required = false) String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }
    //end::optionalurlvariable[]

    @GetMapping("/greeting/salute")
    public Greeting salute(@RequestParam(required = false, defaultValue = "John") String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }
}
