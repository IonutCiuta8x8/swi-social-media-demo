import java.util.Objects;

record User(String displayName,
            String username,
            int followerCount,
            AccountType accountType) {
}
