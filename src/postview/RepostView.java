package postview;

import post.Repost;

import static postview.PostViewUtils.*;

public record RepostView(Repost post) implements IPostView {
    private static final String template = """
            @%s%s reposted:
            | 📱%s
            | | 🗣️ @%s%s: %s
            | | ---
            | ❤️ %d, ⏰ %s
            | ---
            """;

    @Override
    public String getView() {
        return template.formatted(
                post.author().username(),
                getAccountTypeBadge(post),
                getContentWithHashTags(post),
                post.originalPost().author().username(),
                getAccountTypeBadge(post.originalPost()),
                getContentWithHashTags(post.originalPost()),
                post.likes(),
                getPostDate(post)
        );
    }
}
