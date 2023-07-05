import java.util.List;

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
}
