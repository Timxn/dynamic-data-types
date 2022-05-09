package inc.boes.praktikum.classes.stack;

public class Stack_Node<T> {
    private T content;
    private Stack_Node<T> next;

    public Stack_Node(T content) {
        this.content = content;
        next = null;
    }

    public T getContent() {
        return content;
    }

    public Stack_Node<T> getNext() {
        return next;
    }

    public void setNext(Stack_Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.content.toString();
    }
}
