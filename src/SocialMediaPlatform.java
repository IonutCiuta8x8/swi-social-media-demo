import java.util.List;

public class SocialMediaPlatform {
    private static final String user = "myuser";
    public static void main(String[] args) {
        TimelineService timelineService = new TimelineService();
        MetricsService metricsService = new MetricsService();

        Timeline timeline = timelineService.getTimelineViaApiCall(user);

        // timelineService.displayTimeline(timeline);

        System.out.println("Most likes: " + metricsService.getMostLikes(timeline));
    }
}

