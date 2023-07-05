class TimelineService {
    private final PostService postService = new PostService();

    public Timeline getTimelineViaApiCall(String userId) {
        System.out.println("Fetching timeline for user [" + userId + "]");
        return TimelineGenerator.timeline;
    }

    public void displayTimeline(Timeline timeline) {
        for (IPost iPost : timeline.getPosts()) {
            if (iPost instanceof Post) {
                Post post = (Post) iPost;
                String postView = postService.getPostView(post);
                System.out.println(postView);
            }

            if (iPost instanceof Repost) {
                Repost repost = (Repost) iPost;
                String repostView = postService.getRepostView(repost);
                System.out.println(repostView);
            }
        }
    }
}
