package example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.micronaut.configuration.picocli.PicocliRunner;
import static io.micronaut.http.HttpRequest.GET;

import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "git-star", header = {
        "@|green       _ _      _             |@", 
        "@|green  __ _(_) |_ __| |_ __ _ _ _  |@",
        "@|green / _` | |  _(_-<  _/ _` | '_| |@",
        "@|green \\__, |_|\\__/__/\\__\\__,_|_|   |@",
        "@|green |___/                        |@"},
        description = "Shows GitHub stars for a project",
        mixinStandardHelpOptions = true, version = "git-star 0.1") 
public class GitStarCommand implements Runnable {

    @Client("https://api.github.com")
    @Inject HttpClient client; 

    @Option(names = {"-v", "--verbose"}, description = "Shows some project details")
    boolean verbose;

    @Parameters(description = {"One or more GitHub slugs (comma separated) to show stargazers for.",
                "  Default: ${DEFAULT-VALUE}"}, split = ",", paramLabel = "<owner/repo>") 
    List<String> githubSlugs = Arrays.asList("micronaut-projects/micronaut-core", "remkop/picocli");

    public static void main(String[] args) {
        int exitCode = PicocliRunner.execute(GitStarCommand.class, args);
        System.exit(exitCode);
    }

    public void run() { 
        for (String slug : githubSlugs) {
            Map<String, Object> m = client.toBlocking().retrieve(
                    GET("/repos/" + slug).header("User-Agent", "remkop-picocli"),
                    Argument.mapOf(String.class, Object.class));
            System.out.printf("%s has %s stars%n", slug, m.get("watchers"));

            if (verbose) {
                String msg = "Description: %s%nLicense: %s%nForks: %s%nOpen issues: %s%n%n";
                System.out.printf(msg, m.get("description"),
                                ((Map) m.get("license")).get("name"),
                                m.get("forks"), m.get("open_issues"));
            }
        }
    }
}