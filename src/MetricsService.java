import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MetricsService {

    /*int getMostLikes(Timeline timeline) {
        List<IPost> posts = new ArrayList<>(timeline.getPosts());
        Collections.sort(posts, new Comparator<IPost>() {
            @Override
            public int compare(IPost post1, IPost post2) {
                return post2.getLikes() - post1.getLikes();
            }
        });
        return posts.get(0).getLikes();
    }*/

    int getMostLikes(Timeline timeline) {
        List<IPost> posts = new ArrayList<>(timeline.getPosts());
        posts.sort((post1, post2) -> post2.getLikes() - post1.getLikes());
        return posts.get(0).getLikes();
    }

    Set<String> getAllHashtags(Timeline timeline) {
        Set<String> tags = new HashSet<>();
        for (var post : timeline.getPosts()) {
            tags.addAll(post.getHashtags());
        }
        return tags;
    }
}





