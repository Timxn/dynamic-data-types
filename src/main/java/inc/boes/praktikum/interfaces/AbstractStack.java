package inc.boes.praktikum.interfaces;

public interface AbstractStack<T> {
    public void push(T object);
    public T pop();
    public T top();
}