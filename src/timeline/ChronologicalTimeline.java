package timeline;

import post.IPost;

import java.util.List;

public record ChronologicalTimeline(
        List<IPost> posts,
        ChronologicalOrder order) implements Timeline {
}
