package display;

import post.PostService;
import post.Repost;

public class RepostDisplayStrategy implements DisplayStrategy<Repost> {
    private final PostService postService;

    public RepostDisplayStrategy(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void display(Repost repost) {
        var view = postService.getRepostView(repost);
        System.out.println(view.getView());
    }
}
