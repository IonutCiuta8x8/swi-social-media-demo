import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            .withZone(ZoneId.systemDefault());

    public String getPostView(Post post) {
        String template =
                "@%s%s posted:\n" +
                        "| 📱 %s\n" +
                        "| ❤️ %d, ⏰ %s\n" +
                        "| ---\n";

        return String.format(
                template,
                post.getAuthor().getUsername(),
                getAccountTypeBadge(post),
                getContentWithHashTags(post),
                post.getLikes(),
                getPostDate(post)
        );
    }

    public String getRepostView(Repost repost) {
        String template =
                "@%s%s reposted:\n" +
                        "| 📱%s\n" +
                        "| | 🗣️ @%s%s: %s\n" +
                        "| | ---\n" +
                        "| ❤️ %d, ⏰ %s\n" +
                        "| ---\n";

        return template.formatted(
                repost.getAuthor().getUsername(),
                getAccountTypeBadge(repost),
                getContentWithHashTags(repost),
                repost.getOriginalPost().getAuthor().getUsername(),
                getAccountTypeBadge(repost.getOriginalPost()),
                getContentWithHashTags(repost.getOriginalPost()),
                repost.getLikes(),
                getPostDate(repost)
        );
    }

    private String getAccountTypeBadge(IPost post) {
        AccountType type = post.getAuthor().getAccountType();
        String badge;

        switch (type) {
            case PREMIUM:
                badge = "✅";
                break;
            case POWER_USER:
                badge = "✳️";
                break;
            case REGULAR:
            default:
                badge = "";
                break;
        }

        return badge;
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

    public String getPostView(IPost input) {
        if (input instanceof Post post) return getPostView(post);
        else if (input instanceof Repost repost) getRepostView(repost);
        return "[invalid post]";
    }
}

