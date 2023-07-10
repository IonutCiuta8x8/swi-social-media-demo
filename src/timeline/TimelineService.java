package timeline;

import post.Post;
import post.PostService;
import post.Repost;
import postview.AdPostViewDecorator;
import postview.IPostView;
import postview.MisinformationPostViewDecorator;

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
                IPostView view = postService.getPostView(post);
                IPostView decoratedView = new AdPostViewDecorator(new MisinformationPostViewDecorator(view));
                System.out.println(decoratedView.getView());
                return;
            }

            if (iPost instanceof Repost repost) {
                IPostView view = postService.getRepostView(repost);
                System.out.println(view.getView());
            }
        });
    }
}
