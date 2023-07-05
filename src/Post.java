import java.util.List;
import java.util.Objects;

class Post implements IPost {
    private final User author;
    private final int likes;
    private final List<String> hashtags;
    private final String content;
    private final long postedAt;

    public Post(User author, String content, List<String> hashtags, int likes, long postedAt) {
        this.author = author;
        this.content = content;
        this.hashtags = hashtags;
        this.likes = likes;
        this.postedAt = postedAt;
    }

    public User getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public String getContent() {
        return content;
    }

    public long getPostedAt() {
        return postedAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author=" + author +
                ", likes=" + likes +
                ", hashtags=" + hashtags +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return likes == post.likes
                && postedAt == post.postedAt
                && Objects.equals(author, post.author)
                && Objects.equals(hashtags, post.hashtags)
                && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, likes, hashtags, content, postedAt);
    }
}
