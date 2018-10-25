package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/api")
public class RegisterController {

    @Post("/register")
    public HttpResponse registerAccount() {
        return HttpResponse.status(HttpStatus.CREATED);
    }
}