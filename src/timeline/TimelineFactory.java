package timeline;

import post.IPost;

import java.util.List;

public class TimelineFactory implements ITimelineFactory {
    private final ChronologicalTimelineFactory timelineFactory = new ChronologicalTimelineFactory();
    private final PrioritizedTimelineFactory prioritizedTimelineFactory = new PrioritizedTimelineFactory();

    public Timeline getTimeline(List<IPost> posts, Order order) {
        if (order.getChronoOrder() != null) {
            return timelineFactory.getTimeline(posts, order);
        }
        return prioritizedTimelineFactory.getTimeline(posts, order);
    }
}
