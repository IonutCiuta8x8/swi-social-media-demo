import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            .withZone(ZoneId.systemDefault());

    public String getPostView(Post post) {
        String template =
                "@%s posted:\n" +
                "| 📱 %s\n" +
                "| ❤️ %d, ⏰ %s\n" +
                "| ---\n";

        return String.format(
                template,
                post.getAuthor().getUsername(),
                getContentWithHashTags(post),
                post.getLikes(),
                getPostDate(post)
        );
    }

    public String getRepostView(Repost repost) {
        String template =
                "@%s reposted:\n" +
                "| 📱%s\n" +
                "| | 🗣️ @%s: %s\n" +
                "| | ---\n" +
                "| ❤️ %d, ⏰ %s\n" +
                "| ---\n";

        return template.formatted(
                repost.getAuthor().getUsername(),
                getContentWithHashTags(repost),
                repost.getOriginalPost().getAuthor().getUsername(),
                getContentWithHashTags(repost.getOriginalPost()),
                repost.getLikes(),
                getPostDate(repost)
        );
    }

    private String getContentWithHashTags(IPost post) {
        List<String> tags = post.getHashtags();

        String it = post.getContent();
        for (int i = 0; i < tags.size(); i++) {
            it = it.replace("$" + (i + 1), tags.get(i));
        }

        return it;
    }

    private String getPostDate(IPost post) {
        return formatter.format(Instant.ofEpochSecond(post.getPostedAt()));
    }
}

