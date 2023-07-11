package display;

import post.PostService;
import post.VideoPost;

public class VideoPostDisplayStrategy implements DisplayStrategy<VideoPost> {
    private final PostService postService;

    public VideoPostDisplayStrategy(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void display(VideoPost post) {
        // TODO
    }
}
