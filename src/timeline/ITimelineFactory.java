package timeline;

import post.IPost;

import java.util.List;

public interface ITimelineFactory {
    Timeline getTimeline(List<IPost> posts, Order order);
}
