package inc.boes.praktikum.classes;

public class SingleLinkedListNode<T extends Comparable> {
    private T data;
    private SingleLinkedListNode next;

    public SingleLinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }
}
