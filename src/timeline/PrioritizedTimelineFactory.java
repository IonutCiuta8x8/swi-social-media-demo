package timeline;

import post.IPost;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrioritizedTimelineFactory {
    public Timeline getPrioritizedTimeline(List<IPost> posts, Priority order) {
        return switch (order) {
            case MOST_FOLLOWERS -> new PrioritizedTimeline(
                    posts.stream()
                            .sorted((p1, p2) -> p2.author().followerCount() - p1.author().followerCount())
                            .collect(Collectors.toList()),
                    order
            );
            case MOST_LIKES -> new PrioritizedTimeline(
                    posts.stream()
                            .sorted(Comparator.comparingInt(IPost::likes).reversed())
                            .collect(Collectors.toList()),
                    order
            );
        };
    }

    public Timeline getPrioritizedTimelineByLikes(List<IPost> posts) {
        return getPrioritizedTimeline(posts, Priority.MOST_LIKES);
    }

    public Timeline getPrioritizedTimelineByFollowers(List<IPost> posts) {
        return getPrioritizedTimeline(posts, Priority.MOST_FOLLOWERS);
    }
}
