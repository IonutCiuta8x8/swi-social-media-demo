import java.util.List;

public class SocialMediaPlatform {
    public static void main(String[] args) {
        TimelineService timelineService = new TimelineService();
        Timeline timeline = timelineService.getTimelineViaApiCall("myuser");
    }
}

