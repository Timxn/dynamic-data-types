package inc.boes.praktikum.interfaces;

import inc.boes.praktikum.classes.stack.Stack_Node;

public interface AbstractStack<T> {
    public void push(T object);
    public T pop();
    public T top();

    public boolean isEmpty();
//    public boolean hasNext();
//    public T next();
//    public void remove();   // UnsopportedOperationException and IllegalStateException could be thrown
}
