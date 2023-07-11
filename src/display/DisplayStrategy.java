package display;

import post.IPost;

public interface DisplayStrategy<E extends IPost> {
    void display(E post);
}
