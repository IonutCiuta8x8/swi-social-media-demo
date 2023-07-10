package postview;

import post.Post;

import static postview.PostViewUtils.*;

public record PostView(Post post) implements IPostView {
    private static final String template = """
            @%s%s posted:
            | 📱 %s
            | ❤️ %d, ⏰ %s
            | ---
            """;

    @Override
    public String getView() {
        return template.formatted(
                post.author().username(),
                getAccountTypeBadge(post),
                getContentWithHashTags(post),
                post.likes(),
                getPostDate(post)
        );
    }
}
