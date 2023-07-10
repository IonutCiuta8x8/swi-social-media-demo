package testers;

import data.Data;
import post.VideoPost;

import java.util.List;

public class TesterForBuilderPattern {

    public static void main(String[] args) {
        var videoPost = new VideoPost(
                Data.Users.john,
                "Greek sunset!",
                List.of("vacay", "summer"),
                "https://www.youtube.com/watch?v=3un2MZfHC2Q",
                "https://i.ytimg.com/vi/3un2MZfHC2Q/hqdefault.jpg",
                720,
                256,
                13,
                Data.Posted.now.get()
        );

        var videoPostFromBuilder = new VideoPost.Builder()
                .author(Data.Users.john)
                .content("Greek sunset!")
                .hashtags(List.of("vacay", "summer"))
                .videoUrl("https://www.youtube.com/watch?v=3un2MZfHC2Q")
                .coverImageUrl("https://i.ytimg.com/vi/3un2MZfHC2Q/hqdefault.jpg")
                .height(720)
                .width(480)
                .likes(13)
                .postedAt(Data.Posted.now.get())
                .build();
    }
}
