package example.micronaut.demo;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/api")
@RestController
public class BookController {

    private static final String ISBN_REGEX = "^1491950358|1680502395$";

    @GetMapping("/books/{isbn:"+ISBN_REGEX+"}")
    public Book show(@PathVariable String isbn) {
        return new Book(isbn, "Building Microservices");
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> list() {
        Book b = new Book("1491950358", "Building Microservices");
        List<Book> books = Collections.singletonList(b);
        return ResponseEntity.ok()
                .header(HttpHeaders.WARNING, "This maybe expired")
                .body(books);
    }

    @GetMapping("/books/ex")
    @ResponseStatus(HttpStatus.OK)
    public void notFound() {
        throw new BookNotFoundException();
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Book book) {
    }
}
