import java.util.List;

public interface IPost {
    User getAuthor();

    String getContent();

    List<String> getHashtags();

    int getLikes();

    long getPostedAt();
}
