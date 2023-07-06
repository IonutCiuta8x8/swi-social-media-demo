import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PostService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
            .withZone(ZoneId.systemDefault());

    public String getPostView(Post post) {
        var template = """
                @%s%s posted:
                | 📱 %s
                | ❤️ %d, ⏰ %s
                | ---
                """;

        return template.formatted(
                post.author().username(),
                getAccountTypeBadge(post),
                getContentWithHashTags(post),
                post.likes(),
                getPostDate(post)
        );
    }

    public String getRepostView(Repost repost) {
        var template = """
                @%s%s reposted:
                | 📱%s
                | | 🗣️ @%s%s: %s
                | | ---
                | ❤️ %d, ⏰ %s
                | ---
                """;

        return template.formatted(
                repost.author().username(),
                getAccountTypeBadge(repost),
                getContentWithHashTags(repost),
                repost.originalPost().author().username(),
                getAccountTypeBadge(repost.originalPost()),
                getContentWithHashTags(repost.originalPost()),
                repost.likes(),
                getPostDate(repost)
        );
    }

    private String getAccountTypeBadge(IPost post) {
        return switch (post.author().accountType()) {
            case PREMIUM -> "✅";
            case POWER_USER -> "✳️";
            case REGULAR -> "";
        };
    }

    private String getContentWithHashTags(IPost post) {
        final var tags = post.hashtags();

        var it = post.content();
        for (int i = 0; i < tags.size(); i++) {
            it = it.replace("$" + (i + 1), tags.get(i));
        }

        return it;
    }

    private String getPostDate(IPost post) {
        return formatter.format(Instant.ofEpochSecond(post.postedAt()));
    }
}
