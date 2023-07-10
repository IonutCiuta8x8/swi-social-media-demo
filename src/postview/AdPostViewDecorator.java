package postview;

import post.IPost;

public class AdPostViewDecorator implements IPostView {
    private final IPostView postView;

    public AdPostViewDecorator(IPostView iPostView) {
        this.postView = iPostView;
    }

    @Override
    public String getView() {
        if (postView.post().isAdd()) {
            return postView.getView() +
                    "| ✨ This is a sponsored post.\n" +
                    "| ---\n";
        }
        return postView.getView();
    }

    @Override
    public IPost post() {
        return postView.post();
    }
}
