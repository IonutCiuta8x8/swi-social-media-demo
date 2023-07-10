package testers;

import data.Data;
import post.IPost;
import post.Post;
import timeline.Order;
import timeline.TimelineFactory;
import timeline.TimelineService;
import user.AccountType;
import user.User;

import java.util.List;

public class TesterForDecoratorPattern {
    public static void main(String[] args) {
        var addPost = new Post(
                new User("Apple", "apple", 233000, AccountType.PREMIUM),
                "The new iPhone awaits you this autumn!",
                List.of(),
                1250,
                Data.Posted._8hAgo,
                true,
                false
        );

        var falsePost = new Post(
                new User("Larry", "truthseeker", 12, AccountType.POWER_USER),
                "The Earth if flat $1",
                List.of("#facts"),
                1250,
                Data.Posted._5minAgo,
                false,
                true
        );

        List<IPost> posts = List.of(
                Data.Posts.elonPostAboutMars,
                addPost,
                Data.Posts.elonPostAbouSocialMedia,
                falsePost
        );

        var timelineFactory = new TimelineFactory();
        var timeline = timelineFactory.getTimeline(posts, Order.newestFirst());

        var timelineService = TimelineService.getInstance();
        timelineService.displayTimeline(timeline);
    }
}
