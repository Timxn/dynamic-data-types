package inc.boes.praktikum.classes.lists;

public class SingleLinkedListNode<T> {
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
