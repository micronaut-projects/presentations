package example.micronaut.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount() {
    }
}
