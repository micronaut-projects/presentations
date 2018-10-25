package example.micronaut;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Validated
@Controller("/api")
public class BookController {
    private static final String ISBN_REGEX = "1491950358|1680502395$";

    @Get("/books/{isbn:"+ISBN_REGEX+"}")
    public Book show(String isbn) {
        return new Book(isbn, "Building Microservices");
    }

    @Get("/books/ex")
    public HttpResponse notFound() {
        throw new BookNotFoundException();
    }

    @Get("/books")
    public HttpResponse<List<Book>> list() {
        Book b = new Book("1491950358", "Building Microservices");
        List<Book> books = Collections.singletonList(b);
        return HttpResponse.ok(books)
                .header(HttpHeaders.WARNING, "This maybe expired");
    }

    @Post("/books")
    public HttpResponse save(@Body @Valid Book book) {
        return HttpResponse.status(HttpStatus.CREATED);
    }
}
