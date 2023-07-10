package post;

import user.User;

import java.util.List;

public record Post(User author,
                   String content,
                   List<String> hashtags,
                   int likes,
                   long postedAt,
                   boolean isAdd,
                   boolean isMisinformation) implements IPost {
}
