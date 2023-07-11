package share;

import post.Post;
import postview.PostViewUtils;

import java.time.Instant;
import java.util.Date;

public class FacebookSharingAdapterService implements PostSharingService {
    private final FacebookSharingSdk facebookSdk;

    public FacebookSharingAdapterService() {
        this.facebookSdk = new FacebookSharingSdk();
    }

    @Override
    public boolean share(Post post) {
        // Adapting our post to the Facebook expected format
        String postContent = PostViewUtils.getContentWithHashTags(post);
        Date date = new Date(Instant.ofEpochSecond(post.postedAt()).toEpochMilli());

        FacebookPost facebookPost = new FacebookPost(postContent, date);
        FacebookSdkResult facebookSdkResult = facebookSdk.shareToFacebook(facebookPost);

        // Adapting Facebook response to our own
        return facebookSdkResult.status() == 0;
    }
}


