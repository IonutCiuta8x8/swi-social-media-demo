package postview;

import post.IPost;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PostViewUtils {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
            .withZone(ZoneId.systemDefault());

    public static String getAccountTypeBadge(IPost post) {
        return switch (post.author().accountType()) {
            case PREMIUM -> "✅";
            case POWER_USER -> "✳️";
            case REGULAR -> "";
        };
    }

    public static String getContentWithHashTags(IPost post) {
        final var tags = post.hashtags();

        var it = post.content();
        for (int i = 0; i < tags.size(); i++) {
            it = it.replace("$" + (i + 1), tags.get(i));
        }

        return it;
    }

    public static String getPostDate(IPost post) {
        return dateFormat.format(Instant.ofEpochSecond(post.postedAt()));
    }
}
