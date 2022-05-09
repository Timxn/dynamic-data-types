package inc.boes.praktikum.interfaces;

public interface AbstractQueue<T> {
    public abstract void enqueue (T data);  //adds to the queue
    public abstract T dequeue ();           //removes oldest entry
    public abstract int size();             //gives legth of the queue back
}
