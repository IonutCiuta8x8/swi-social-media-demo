import java.util.List;

class Post {
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
}
