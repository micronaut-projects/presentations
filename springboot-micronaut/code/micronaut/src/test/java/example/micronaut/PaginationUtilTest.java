package example.micronaut;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PaginationUtilTest {

    @Test
    public void generateUri() {
        assertEquals("http://localhost:8080/books?page=2&size=20",
                PaginationUtil.generateUri("http://localhost:8080/books", 2, 20));
    }
}
