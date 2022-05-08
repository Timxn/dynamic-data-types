package inc.boes.praktikum.interfaces;

import inc.boes.praktikum.classes.TreeNode;

public interface AbstractBinarySearchTree<T extends Number> {
    void insert(T value);
    void delete(T value);
    boolean search(T value);
    boolean isEmpty(TreeNode<T> node);
    String toString(Traversal traversal);
    enum Traversal{
        PreOrder,
        InOrder,
        PostOrder
    }
    boolean hasNext(TreeNode<T> node);
    TreeNode<T> next();

}
