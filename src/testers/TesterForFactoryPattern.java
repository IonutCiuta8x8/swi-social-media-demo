package testers;

import data.Data;
import post.IPost;
import timeline.*;

import java.util.List;

public class TesterForFactoryPattern {
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
        TimelineService service = TimelineService.getInstance();

        // Factories
        ChronologicalTimelineFactory chronoFactory = new ChronologicalTimelineFactory();
        PrioritizedTimelineFactory prioritizedFactory = new PrioritizedTimelineFactory();

        // Timeline ordered chronologically
        var newestTimeline = chronoFactory.getChronologicalTimeline(posts, ChronologicalOrder.NEWEST);
        var oldestTimeline = chronoFactory.getChronologicalTimeline(posts, ChronologicalOrder.OLDEST);

        System.out.println("> Newest first");
        service.displayTimeline(newestTimeline);
        System.out.println();

        System.out.println("> Oldest first");
        service.displayTimeline(oldestTimeline);
        System.out.println();

        // Timeline ordered chronologically
        var likesTimeline = prioritizedFactory.getPrioritizedTimeline(posts, Priority.MOST_LIKES);
        var followersTimeline = prioritizedFactory.getPrioritizedTimeline(posts, Priority.MOST_FOLLOWERS);

        System.out.println("> Most likes first");
        service.displayTimeline(likesTimeline);
        System.out.println();

        System.out.println("> Most popular first");
        service.displayTimeline(followersTimeline);
        System.out.println();
    }
}
