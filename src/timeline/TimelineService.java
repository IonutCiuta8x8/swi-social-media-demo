package timeline;

import display.PostDisplayStrategy;
import display.RepostDisplayStrategy;
import display.VideoPostDisplayStrategy;
import post.Post;
import post.PostService;
import post.Repost;
import post.VideoPost;

public final class TimelineService {
    private static TimelineService instance;

    private final PostDisplayStrategy postDisplayStrategy;
    private final RepostDisplayStrategy repostDisplayStrategy;
    private final VideoPostDisplayStrategy videoPostDisplayStrategy;

    private TimelineService(PostService postService) {
        this.postDisplayStrategy = new PostDisplayStrategy(postService);
        this.repostDisplayStrategy = new RepostDisplayStrategy(postService);
        this.videoPostDisplayStrategy = new VideoPostDisplayStrategy(postService);
    }

    public static synchronized TimelineService getInstance() {
        if (instance == null) {
            instance = new TimelineService(PostService.getInstance());
        }
        return instance;
    }

    public void displayTimeline(Timeline timeline) {
        timeline.posts().forEach(iPost -> {
            if (iPost instanceof Post post) {
                postDisplayStrategy.display(post);
                return;
            }

            if (iPost instanceof Repost repost) {
                repostDisplayStrategy.display(repost);
                return;
            }

            if (iPost instanceof VideoPost videoPost) {
                videoPostDisplayStrategy.display(videoPost);
            }
        });
    }
}
