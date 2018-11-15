package example.micronaut;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Book {
    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    @NotBlank
    private String name;

    public Book() {}

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
