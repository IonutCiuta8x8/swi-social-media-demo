import java.util.List;

record Repost(User author,
              String content,
              List<String> hashtags,
              int likes,
              long postedAt,
              Post originalPost) implements IPost {
}
