import java.util.List;

class Timeline {
    private final List<IPost> posts;

    public Timeline(List<IPost> posts) {
        this.posts = posts;
    }

    public List<IPost> getPosts() {
        return posts;
    }
}
