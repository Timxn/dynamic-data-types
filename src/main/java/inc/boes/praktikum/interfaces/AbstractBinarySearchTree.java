package inc.boes.praktikum.interfaces;

import inc.boes.praktikum.classes.trees.TreeNode;

public interface AbstractBinarySearchTree<T> {
    void insert(T value);
    void delete(T value);
    boolean search(T value);
    boolean isEmpty();
    String toString(Traversal traversal);

    /**
     * All possibilities for the traversal
     */
    enum Traversal{
        PreOrder,
        InOrder,
        PostOrder
    }

}
