package testers;

import data.Data;
import post.Post;
import share.FacebookSharingAdapterService;
import share.PostSharingService;

public class TesterForAdapterPattern {

    public static void main(String[] args) {
        PostSharingService sharingService = new FacebookSharingAdapterService();

        Post post = Data.Posts.zuckPostAboutSocialMedia;
        boolean result = sharingService.share(post);
        System.out.println("Post sharing " + (result ? "succeeded" : "failed"));
    }
}
