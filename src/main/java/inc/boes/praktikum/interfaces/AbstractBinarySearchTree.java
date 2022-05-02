package inc.boes.praktikum.interfaces;

public interface AbstractBinarySearchTree<T extends Comparable> {
    public void insert(T data);
    public void delete(T data);
    public boolean search(T data);

    public boolean isEmpty();

    public String toString(String Traversal);
}
