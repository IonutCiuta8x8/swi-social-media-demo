import java.time.Instant;
import java.util.List;
import java.util.Objects;

public record VideoPost(User author,
                        String content,
                        List<String> hashtags,
                        String videoUrl,
                        String coverImageUrl,
                        int height,
                        int width,
                        int likes,
                        long postedAt) implements IPost {

    static class Builder {
        private User author;
        private String content;
        private List<String> hashtags;
        private String videoUrl;
        private String coverImageUrl;
        private int height;
        private int width;
        private int likes;
        private long postedAt;

        public Builder author(User author) {
            // Validation example
            Objects.requireNonNull(author);
            this.author = author;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder hashtags(List<String> hashtags) {
            this.hashtags = hashtags;
            return this;
        }

        public Builder videoUrl(String videoUrl) {
            // Validation example
            Objects.requireNonNull(videoUrl);
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder coverImageUrl(String coverImageUrl) {
            // Validation example
            Objects.requireNonNull(coverImageUrl);
            this.coverImageUrl = coverImageUrl;
            return this;
        }

        public Builder height(int height) {
            // Validation example
            if (height < 480)
                throw new IllegalArgumentException("Height too low.");
            this.height = height;
            return this;
        }

        public Builder width(int width) {
            // Validation example
            if (width < 480)
                throw new IllegalArgumentException("Width too low.");
            this.width = width;
            return this;
        }

        public Builder likes(int likes) {
            this.likes = likes;
            return this;
        }

        public Builder postedAt(long postedAt) {
            // Validation example
            if (postedAt < Instant.now().getEpochSecond())
                throw new IllegalArgumentException("Can't post in the future.");
            this.postedAt = postedAt;
            return this;
        }

        public VideoPost build() {
            // Validation can also happen here.
            // It really depends on what you want to achieve.
            return new VideoPost(
                    this.author,
                    this.content,
                    this.hashtags,
                    this.videoUrl,
                    this.coverImageUrl,
                    this.height,
                    this.width,
                    this.likes,
                    this.postedAt
            );
        }
    }
}
