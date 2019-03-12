package example;

import example.annotation.AvroEntity;
import io.micronaut.core.annotation.Introspected;

@AvroEntity
@Introspected
public class Book {
    private String title;
    private int pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
