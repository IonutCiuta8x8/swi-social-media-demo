import java.util.List;

public class SocialMediaPlatform {
    private static final String user = "myuser";
    public static void main(String[] args) {
        TimelineService timelineService = new TimelineService();
        PostService postService = new PostService();
        MetricsService metricsService = new MetricsService();
        SearchService searchService = new SearchService();

        Timeline timeline = timelineService.getTimelineViaApiCall(user);

        // timelineService.displayTimeline(timeline);

        // System.out.println("Most likes: " + metricsService.getMostLikes(timeline));

        var elonUsername = "therealelon";
        var msg = searchService.findLatestPostForUser(timeline, elonUsername)
                .map(postService::getPostView)
                .orElse(elonUsername + " did not post recently 💔");
        System.out.println(msg);

        var otherUser = "melonman";
        var otherMsg = searchService.findLatestPostForUser(timeline, otherUser)
                .map(postService::getPostView)
                .orElse(otherUser + " did not post recently 💔");
        System.out.println(otherMsg);

        System.out.println(metricsService.getAllHashtags(timeline));
    }
}

