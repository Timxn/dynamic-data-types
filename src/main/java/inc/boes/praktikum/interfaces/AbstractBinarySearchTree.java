package inc.boes.praktikum.interfaces;

public interface AbstractBinarySearchTree<T extends Number> {
    void insert(T data);
    void delete(T data);
    boolean search(T data);
    boolean isEmpty();
    String toString(String Traversal);
}
