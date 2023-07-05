import java.util.List;
import java.util.Objects;

class Timeline {
    private final List<IPost> posts;

    public Timeline(List<IPost> posts) {
        this.posts = posts;
    }

    public List<IPost> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeline timeline = (Timeline) o;
        return Objects.equals(posts, timeline.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts);
    }
}
