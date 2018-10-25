package example.micronaut.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Book {
    @NotBlank
    @NotBlank
    private String isbn;

    @NotBlank
    @NotNull
    private String name;

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
