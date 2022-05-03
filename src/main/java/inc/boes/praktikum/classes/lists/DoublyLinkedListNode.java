package inc.boes.praktikum.classes.lists;

public class DoublyLinkedListNode<T> {
    private T data;
    private DoublyLinkedListNode previous;
    private DoublyLinkedListNode next;

    public DoublyLinkedListNode(T pData, DoublyLinkedListNode pPrevious) {
        this.data = pData;
        this.previous = pPrevious;
        this.next = null;
    }

    public DoublyLinkedListNode(T pData) {
        this.data = pData;
        this.previous = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }
}
