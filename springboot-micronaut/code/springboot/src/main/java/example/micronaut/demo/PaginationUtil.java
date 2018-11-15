package example.micronaut.demo;

import org.springframework.web.util.UriComponentsBuilder;

public class PaginationUtil {

    static String generateUri(String baseUrl, int page, int size) {

        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("page", page)
                .queryParam("size", size).toUriString();
    }
}
