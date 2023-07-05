import java.util.List;

public interface IPost {
    User author();

    String content();

    List<String> hashtags();

    int likes();

    long postedAt();
}
