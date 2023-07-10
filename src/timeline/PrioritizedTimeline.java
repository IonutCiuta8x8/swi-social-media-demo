package timeline;

import post.IPost;

import java.util.List;

public record PrioritizedTimeline(
        List<IPost> posts,
        Priority priority) implements Timeline {
}