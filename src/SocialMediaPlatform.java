import java.util.List;

public class SocialMediaPlatform {
    private static final String user = "myuser";
    public static void main(String[] args) {
        TimelineService timelineService = new TimelineService();

        Timeline timeline = timelineService.getTimelineViaApiCall(user);

        // timelineService.displayTimeline(timeline);

        MetricsService metricsService = new MetricsService();

        System.out.println("Most likes: " + metricsService.getMostLikes(timeline));
    }
}

