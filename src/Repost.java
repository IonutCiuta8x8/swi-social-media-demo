import java.util.List;
import java.util.Objects;

public class Repost implements IPost {
    private final User author;
    private final int likes;
    private final List<String> hashtags;
    private final String content;
    private final long postedAt;

    private final Post originalPost;

    public Repost(User author, String content, List<String> hashtags, int likes, long postedAt, Post originalPost) {
        this.author = author;
        this.content = content;
        this.hashtags = hashtags;
        this.likes = likes;
        this.postedAt = postedAt;
        this.originalPost = originalPost;
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

    public Post getOriginalPost() {
        return originalPost;
    }

    @Override
    public String toString() {
        return "Repost{" +
                "author=" + author +
                ", likes=" + likes +
                ", hashtags=" + hashtags +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                ", originalPost=" + originalPost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repost repost = (Repost) o;
        return likes == repost.likes
                && postedAt == repost.postedAt
                && Objects.equals(author, repost.author)
                && Objects.equals(hashtags, repost.hashtags)
                && Objects.equals(content, repost.content)
                && Objects.equals(originalPost, repost.originalPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, likes, hashtags, content, postedAt, originalPost);
    }
}
