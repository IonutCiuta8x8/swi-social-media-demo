package timeline;

import post.Post;
import post.PostService;
import post.Repost;

public final class TimelineService {
    private static TimelineService instance;
    private final PostService postService;

    private TimelineService(PostService postService) {
        this.postService = postService;
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
                var view = postService.getPostView(post);
                System.out.println(view);
            }

            if (iPost instanceof Repost repost) {
                var view = postService.getRepostView(repost);
                System.out.println(view);
            }
        });
    }
}
