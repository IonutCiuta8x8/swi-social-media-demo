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
}
