import java.util.List;

record Post(User author,
            String content,
            List<String> hashtags,
            int likes,
            long postedAt) implements IPost {
}
