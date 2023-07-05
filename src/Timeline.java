import java.util.List;

class Timeline {
    private final List<Post> posts;

    public Timeline(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
