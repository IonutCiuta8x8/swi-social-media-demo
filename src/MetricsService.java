import java.util.Comparator;

public class MetricsService {
    int getMostLikes(Timeline timeline) {
        return timeline.posts().stream().map(IPost::likes)
                .max(Comparator.naturalOrder()).orElse(-1);
    }
}





