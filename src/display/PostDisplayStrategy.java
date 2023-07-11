package display;

import post.Post;
import post.PostService;
import postview.AdPostViewDecorator;
import postview.MisinformationPostViewDecorator;

public class PostDisplayStrategy implements DisplayStrategy<Post> {
    private final PostService postService;

    public PostDisplayStrategy(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void display(Post post) {
        var view = postService.getPostView(post);
        var decoratedView = new AdPostViewDecorator(new MisinformationPostViewDecorator(view));
        System.out.println(decoratedView.getView());
    }
}

