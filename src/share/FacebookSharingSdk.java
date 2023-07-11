package share;

public final class FacebookSharingSdk {
    public FacebookSdkResult shareToFacebook(FacebookPost facebookPost) {
        System.out.println("Sharing to facebook:\n> " + facebookPost);
        var result = send(facebookPost);
        System.out.println("Got result from Facebook:\n> " + result);
        return result;
    }

    private FacebookSdkResult send(FacebookPost facebookPost) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new FacebookSdkResult(0);
    }
}
