package inc.boes.praktikum.interfaces;

public interface AbstractMinHeap<T extends Comparable>{
    public void insert(T value);
    public void delete(T value); //deletes first instance of value
    public T getMin();
    public boolean exists(T value);
    public boolean isEmpty();
    public String toString();
}
