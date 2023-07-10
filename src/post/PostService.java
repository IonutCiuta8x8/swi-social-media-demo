package post;

import postview.IPostView;
import postview.PostView;
import postview.RepostView;

public final class PostService {
    private static PostService instance;

    private PostService() {
    }

    public static synchronized PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    public IPostView getPostView(Post post) {
        return new PostView(post);
    }

    public IPostView getRepostView(Repost repost) {
        return new RepostView(repost);
    }
}
