package post;

import user.User;

import java.util.List;

public record Repost(User author,
                     String content,
                     List<String> hashtags,
                     int likes,
                     long postedAt,
                     Post originalPost) implements IPost {
}
