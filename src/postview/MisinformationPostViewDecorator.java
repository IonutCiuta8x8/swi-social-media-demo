package postview;

import post.IPost;

public class MisinformationPostViewDecorator implements IPostView {

    private final IPostView postView;

    public MisinformationPostViewDecorator(IPostView postView) {
        this.postView = postView;
    }

    @Override
    public String getView() {
        if (postView.post().isMisinformation()) {
            return postView.getView() +
                    "| ⚠️ This post might be promoting misinformation.\n" +
                    "| ---\n";
        }
        return postView.getView();
    }

    @Override
    public IPost post() {
        return postView.post();
    }
}
