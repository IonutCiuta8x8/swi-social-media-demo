class TimelineService {
    private final PostService postService = new PostService();

    public Timeline getTimelineViaApiCall(String userId) {
        System.out.println("Fetching timeline for user [" + userId + "]");
        return TimelineGenerator.timeline;
    }

    public void displayTimeline(Timeline timeline) {
        timeline.posts().forEach(iPost -> {
            if (iPost instanceof Post post) {
                var view = postService.getPostView(post);
                System.out.println(view);
            }

            if (iPost instanceof Repost repost) {
                var view = postService.getRepostView(repost);
                System.out.println(view);
            }
        });
    }
}
