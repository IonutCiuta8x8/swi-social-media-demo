import java.util.List;

public class SocialMediaPlatform {
    private static final String user = "myuser";
    public static void main(String[] args) {
        TimelineService timelineService = new TimelineService();

        Timeline timeline = timelineService.getTimelineViaApiCall(user);

        System.out.println(timeline);

        // Part 1
        // Task1: can we make the models slimmer? [ records ]

        // Task2: let's display posts, but just the basic stuff [ forEach, pattern matching, enhanced switch, method reference ]

        // Task3: group by author the post count [ var ]


        // Part 2
        // Task1: let's display posts properly [ refactor Part1.Task2 with streams ]

        // Task2: let's find the latest post for a specific user
        // and print a default message if none found [ Optional ]

        // Task3: let's return a set of all hashtags

        // Task4: let's sort the posts by most liked

        // Task5: let's redo Part1.Task3 and make it prettier

        // Task6: what if getting the timeline takes some time and we don't want to block?
    }
}

