package user;

public record User(String displayName,
                   String username,
                   int followerCount,
                   AccountType accountType) {
}
