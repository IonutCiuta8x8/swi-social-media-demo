import java.util.ArrayList;

public class SearchService {

    public IPost findLatestPostForUser(Timeline timeline, String username) {
        var posts = new ArrayList<>(timeline.getPosts());
        posts.sort((post1, post2) -> Long.compare(post2.getPostedAt(), post1.getPostedAt()));

        for (var post : posts) {
            if (post.getAuthor().getUsername().equals(username)) {
                return post;
            }
        }
        return null;
    }
}
