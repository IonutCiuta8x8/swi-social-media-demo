class TimelineService {
    private final PostService postService = new PostService();

    public Timeline getTimelineViaApiCall(String userId) {
        System.out.println("Fetching timeline for user [" + userId + "]");
        return TimelineGenerator.timeline;
    }
}
