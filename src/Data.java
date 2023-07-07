import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Supplier;

public class Data {
    static class Users {
        static final User elon = new User("Elon Musk", "therealelon", 1000000, AccountType.POWER_USER);
        static final User zuck = new User("Mark Zuckenberg", "therealzuck", 250000, AccountType.PREMIUM);
        static final User teslaFanboy = new User("Joe", "joelovetesla", 100, AccountType.REGULAR);
        static final User appleFanboy = new User("Steve", "steveloveapple", 120, AccountType.PREMIUM);
        static final User lex = new User("Lex Friedman", "lextfriedman", 120000, AccountType.PREMIUM);
        static final User john = new User("John", "johnfromhighschool", 77, AccountType.REGULAR);
    }

    static class Hashtags {
        static final String twitter = "#twitter";
        static final String socialMedia = "#socialmedia";
        static final String apple = "#apple";
        static final String iphone = "#iphone";
        static final String usa = "#usa";
        static final String meta = "#meta";
    }

    static class Posted {
        static final Supplier<Long> now = () -> Instant.now().getEpochSecond();
        static final long _1minAgo = Instant.now().minus(1, ChronoUnit.MINUTES).getEpochSecond();
        static final long _5minAgo = Instant.now().minus(5, ChronoUnit.MINUTES).getEpochSecond();
        static final long _15minAgo = Instant.now().minus(15, ChronoUnit.MINUTES).getEpochSecond();
        static final long _30minAgo = Instant.now().minus(30, ChronoUnit.MINUTES).getEpochSecond();
        static final long _1hAgo = Instant.now().minus(1, ChronoUnit.HOURS).getEpochSecond();
        static final long _8hAgo = Instant.now().minus(8, ChronoUnit.HOURS).getEpochSecond();
        static final long _1dayAgo = Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond();
        static final long _7daysAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
        static final long _30daysAgo = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
    }

    static class Posts {
        static final Post elonPostAboutMars = new Post(Users.elon, "Can't wait to be the president of Mars.", List.of(), 1499, Posted._1minAgo);
        static final Post elonPostAbouSocialMedia = new Post(Users.elon, "I will fix $1.", List.of(Hashtags.socialMedia), 120, Posted._8hAgo);
        static final Post elonPostAbouApi = new Post(Users.elon, "$1 will start charging devs more for API usage.", List.of(Hashtags.twitter), 120, Posted._1dayAgo);
        static final Post zuckPostAboutSocialMedia = new Post(Users.zuck, "$1 is not broken. We at $2 work everyday to make it better.", List.of(Hashtags.socialMedia, Hashtags.meta), 300, Posted._15minAgo);
        static final Post fanboyPostAboutApple = new Post(Users.appleFanboy, "$1 still makes the best products", List.of(Hashtags.apple), 30, Posted._5minAgo);
        static final Post fanboyPostAboutIphone = new Post(Users.appleFanboy, "Can't wait to pay more money to buy the same $1 this year. $2", List.of(Hashtags.iphone, Hashtags.apple), 30, Posted._1hAgo);
    }

    static class Reposts {
        static final Repost lexMarsRepost = new Repost(Users.lex, "Yes, let's make it happen!", List.of(), 300, Posted.now.get(), Posts.elonPostAboutMars);
        static final Repost lexSocialMediaRepost = new Repost(Users.lex, "What can be we do to make it better though? $1", List.of(Hashtags.socialMedia), 300, Posted.now.get(), Posts.zuckPostAboutSocialMedia);
    }
}
