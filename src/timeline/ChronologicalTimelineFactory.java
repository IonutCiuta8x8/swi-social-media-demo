package timeline;

import post.IPost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ChronologicalTimelineFactory implements ITimelineFactory {
    @Override
    public Timeline getTimeline(List<IPost> posts, Order order) {
        Objects.requireNonNull(order.getChronoOrder());
        return getChronologicalTimeline(posts, order.getChronoOrder());
    }

    public Timeline getChronologicalTimeline(List<IPost> posts, ChronologicalOrder order) {
        var copyOfPosts = new ArrayList<>(posts);
        switch (order) {
            case OLDEST -> copyOfPosts.sort(Comparator.comparingLong(IPost::postedAt));
            case NEWEST -> copyOfPosts.sort(Comparator.comparingLong(IPost::postedAt).reversed());
        }
        return new ChronologicalTimeline(copyOfPosts, order);
    }

    public Timeline getTimelineWithNewestPostsFirst(List<IPost> posts) {
        return getChronologicalTimeline(posts, ChronologicalOrder.NEWEST);
    }

    public Timeline getTimelineWithOldestPostsFirst(List<IPost> posts) {
        return getChronologicalTimeline(posts, ChronologicalOrder.OLDEST);
    }
}
