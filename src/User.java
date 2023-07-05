import java.util.Objects;

class User {
    private final String displayName;
    private final String username;
    private final int followerCount;
    private final AccountType accountType;

    public User(String displayName, String username, int followerCount, AccountType accountType) {
        this.displayName = displayName;
        this.username = username;
        this.followerCount = followerCount;
        this.accountType = accountType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUsername() {
        return username;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "User{" +
                "displayName='" + displayName + '\'' +
                ", username='" + username + '\'' +
                ", followerCount=" + followerCount +
                ", accountType=" + accountType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return followerCount == user.followerCount
                && Objects.equals(displayName, user.displayName)
                && Objects.equals(username, user.username)
                && accountType == user.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, username, followerCount, accountType);
    }
}
