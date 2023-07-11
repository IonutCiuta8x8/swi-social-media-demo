package testers;

import data.Data;
import post.IPost;
import timeline.Order;
import timeline.TimelineFactory;
import timeline.TimelineService;

import java.util.List;

public class TesterForStrategyPattern {
    public static void main(String[] args) {
        List<IPost> posts = List.of(
                Data.Posts.elonPostAboutMars,
                Data.Posts.elonPostAbouSocialMedia,
                Data.Posts.elonPostAbouApi,
                Data.Posts.fanboyPostAboutApple,
                Data.Posts.fanboyPostAboutIphone,
                Data.Posts.zuckPostAboutSocialMedia,
                Data.Reposts.lexMarsRepost,
                Data.Reposts.lexSocialMediaRepost,
                Data.Posts.addPost,
                Data.Posts.falsePost
        );

        var timelineFactory = new TimelineFactory();
        var timeline = timelineFactory.getTimeline(posts, Order.newestFirst());

        var timelineService = TimelineService.getInstance();
        timelineService.displayTimeline(timeline);
    }
}
