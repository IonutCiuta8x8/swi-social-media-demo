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
        var latestPost = searchService.findLatestPostForUser(timeline, elonUsername);
        if (latestPost != null) {
            System.out.println(postService.getPostView(latestPost));
        } else {
            System.out.println(elonUsername + " did not post yet.");
        }
    }
}

