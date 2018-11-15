package example.micronaut.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/httpstatus")
@RestController
public class StatusController {

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public void voidReturn() {

    }
}
