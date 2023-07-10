package testers;

import data.Data;
import post.IPost;
import timeline.*;

import java.util.List;

public class TesterForAbstractFactoryPattern {
    public static void main(String[] args) {
        List<IPost> posts = List.of(
                Data.Posts.elonPostAboutMars,
                Data.Posts.elonPostAbouSocialMedia,
                Data.Posts.elonPostAbouApi,
                Data.Posts.fanboyPostAboutApple,
                Data.Posts.fanboyPostAboutIphone,
                Data.Posts.zuckPostAboutSocialMedia,
                Data.Reposts.lexMarsRepost,
                Data.Reposts.lexSocialMediaRepost
        );

        // For display reasons
        TimelineService service = new TimelineService();

        // Factories
        var timelineFactory = new TimelineFactory();

        // Timeline ordered chronologically
        var newestTimeline = timelineFactory.getTimeline(posts, Order.newestFirst());
        var oldestTimeline = timelineFactory.getTimeline(posts, Order.oldestFirst());

        // Timeline ordered chronologically
        var likesTimeline = timelineFactory.getTimeline(posts, Order.mostLikesFirst());
        var followersTimeline = timelineFactory.getTimeline(posts, Order.mostFollowersFirst());

        System.out.println("> Newest first");
        service.displayTimeline(newestTimeline);
        System.out.println();

        System.out.println("> Oldest first");
        service.displayTimeline(oldestTimeline);
        System.out.println();

        // Timeline ordered chronologically
//        var likesTimeline = timelineFactory.getTimeline(posts, Order.mostLikesFirst());
//        var followersTimeline = timelineFactory.getTimeline(posts, Order.mostFollowersFirst());

        System.out.println("> Most likes first");
        service.displayTimeline(likesTimeline);
        System.out.println();

        System.out.println("> Most popular first");
        service.displayTimeline(followersTimeline);
        System.out.println();
    }
}
