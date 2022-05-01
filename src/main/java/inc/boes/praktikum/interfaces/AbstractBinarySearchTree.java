package inc.boes.praktikum.*;

public interface AbstractBinarySearchTree<T extends Comparable> {
    public void insertion(T data);
    public void deletion(T data);
    public boolean search(T data);
}
