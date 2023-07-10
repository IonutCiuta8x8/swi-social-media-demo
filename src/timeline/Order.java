package timeline;

public class Order {
    private final ChronologicalOrder chronoOrder;
    private final Priority priority;

    private Order(ChronologicalOrder chronoOrder) {
        this.chronoOrder = chronoOrder;
        this.priority = null;
    }

    private Order(Priority priority) {
        this.chronoOrder = null;
        this.priority = priority;
    }

    public static Order newestFirst() {
        return new Order(ChronologicalOrder.NEWEST);
    }

    public static Order oldestFirst() {
        return new Order(ChronologicalOrder.OLDEST);
    }

    public static Order mostFollowersFirst() {
        return new Order(Priority.MOST_FOLLOWERS);
    }

    public static Order mostLikesFirst() {
        return new Order(Priority.MOST_LIKES);
    }

    public ChronologicalOrder getChronoOrder() {
        return chronoOrder;
    }

    public Priority getPriority() {
        return priority;
    }
}
