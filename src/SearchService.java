import java.util.Optional;

public class SearchService {

    public Optional<IPost> findLatestPostForUser(Timeline timeline, String username) {
        return timeline.posts().stream()
                .sorted((p1, p2) -> Long.compare(p2.postedAt(), p1.postedAt()))
                .filter(p -> p.author().username().equals(username))
                .findFirst();
    }
}
