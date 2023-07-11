package timeline;

import display.DisplayStrategy;
import display.PostDisplayStrategy;
import display.RepostDisplayStrategy;
import display.VideoPostDisplayStrategy;
import post.*;

import java.util.Map;

@SuppressWarnings("rawtypes,unchecked")
public final class TimelineService {
    private static TimelineService instance;

    private final Map<Class<? extends IPost>, DisplayStrategy> strategies;

    private TimelineService(PostService postService) {
        this.strategies = Map.of(
                Post.class, new PostDisplayStrategy(postService),
                Repost.class, new RepostDisplayStrategy(postService),
                VideoPost.class, new VideoPostDisplayStrategy(postService)
        );
    }

    public static synchronized TimelineService getInstance() {
        if (instance == null) {
            instance = new TimelineService(PostService.getInstance());
        }
        return instance;
    }

    public void displayTimeline(Timeline timeline) {
        timeline.posts().forEach(iPost -> strategies.get(iPost.getClass()).display(iPost));
    }
}
