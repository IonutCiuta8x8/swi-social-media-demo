import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MetricsService {
    int getMostLikes(Timeline timeline) {
        return timeline.posts().stream().map(IPost::likes)
                .max(Comparator.naturalOrder()).orElse(-1);
    }

    Set<String> getAllHashtags(Timeline timeline) {
        return timeline.posts().stream()
                .map(IPost::hashtags)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }
}





