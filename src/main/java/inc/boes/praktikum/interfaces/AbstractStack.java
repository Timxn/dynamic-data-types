package inc.boes.praktikum.*;

public interface AbstractStack<T> {
    public void push(T object);
    public T pop();
    public T top();
}
