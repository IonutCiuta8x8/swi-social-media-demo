package data;

import post.Post;
import post.Repost;
import user.AccountType;
import user.User;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Supplier;

public class Data {
    public static class Users {
        public static final User elon = new User("Elon Musk", "therealelon", 1000000, AccountType.POWER_USER);
        public static final User zuck = new User("Mark Zuckenberg", "therealzuck", 250000, AccountType.PREMIUM);
        public static final User teslaFanboy = new User("Joe", "joelovetesla", 100, AccountType.REGULAR);
        public static final User appleFanboy = new User("Steve", "steveloveapple", 120, AccountType.PREMIUM);
        public static final User lex = new User("Lex Friedman", "lextfriedman", 120000, AccountType.PREMIUM);
        public static final User john = new User("John", "johnfromhighschool", 77, AccountType.REGULAR);
    }

    public static class Hashtags {
        public static final String twitter = "#twitter";
        public static final String socialMedia = "#socialmedia";
        public static final String apple = "#apple";
        public static final String iphone = "#iphone";
        public static final String usa = "#usa";
        public static final String meta = "#meta";
    }

    public static class Posted {
        public static final Supplier<Long> now = () -> Instant.now().getEpochSecond();
        public static final long _1minAgo = Instant.now().minus(1, ChronoUnit.MINUTES).getEpochSecond();
        public static final long _5minAgo = Instant.now().minus(5, ChronoUnit.MINUTES).getEpochSecond();
        public static final long _15minAgo = Instant.now().minus(15, ChronoUnit.MINUTES).getEpochSecond();
        public static final long _30minAgo = Instant.now().minus(30, ChronoUnit.MINUTES).getEpochSecond();
        public static final long _1hAgo = Instant.now().minus(1, ChronoUnit.HOURS).getEpochSecond();
        public static final long _8hAgo = Instant.now().minus(8, ChronoUnit.HOURS).getEpochSecond();
        public static final long _1dayAgo = Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond();
        public static final long _7daysAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
        public static final long _30daysAgo = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
    }

    public static class Posts {
        public static final Post elonPostAboutMars = new Post(Users.elon, "Can't wait to be the president of Mars.", List.of(), 1499, Posted._1minAgo);
        public static final Post elonPostAbouSocialMedia = new Post(Users.elon, "I will fix $1.", List.of(Hashtags.socialMedia), 120, Posted._8hAgo);
        public static final Post elonPostAbouApi = new Post(Users.elon, "$1 will start charging devs more for API usage.", List.of(Hashtags.twitter), 387, Posted._1dayAgo);
        public static final Post zuckPostAboutSocialMedia = new Post(Users.zuck, "$1 is not broken. We at $2 work everyday to make it better.", List.of(Hashtags.socialMedia, Hashtags.meta), 247, Posted._15minAgo);
        public static final Post fanboyPostAboutApple = new Post(Users.appleFanboy, "$1 still makes the best products", List.of(Hashtags.apple), 11, Posted._5minAgo);
        public static final Post fanboyPostAboutIphone = new Post(Users.appleFanboy, "Can't wait to pay more money to buy the same $1 this year. $2", List.of(Hashtags.iphone, Hashtags.apple), 30, Posted._1hAgo);
    }

    public static class Reposts {
        public static final Repost lexMarsRepost = new Repost(Users.lex, "Yes, let's make it happen!", List.of(), 500, Posted.now.get(), Posts.elonPostAboutMars);
        public static final Repost lexSocialMediaRepost = new Repost(Users.lex, "What can be we do to make it better though? $1", List.of(Hashtags.socialMedia), 1001, Posted.now.get(), Posts.zuckPostAboutSocialMedia);
    }
}
