package post;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class PostService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
            .withZone(ZoneId.systemDefault());

    private static PostService instance;

    private PostService() {
    }

    public static synchronized PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

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

    public String getPostView(IPost input) {
        if (input instanceof Post post) return getPostView(post);
        else if (input instanceof Repost repost) getRepostView(repost);
        return "[invalid post]";
    }
}
