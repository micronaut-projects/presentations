package example.micronaut;

import io.micronaut.http.uri.UriTemplate;

import java.util.HashMap;
import java.util.Map;

public class PaginationUtil {

    static String generateUri(String baseUrl, int page, int size) {
        String template = baseUrl + "{?page,size}";
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("page", page);
        arguments.put("size", size);
        UriTemplate uriTemplate = new UriTemplate(template);
        return uriTemplate.expand(arguments);
    }
}
