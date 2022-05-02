package inc.boes.praktikum.classes;

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

    public void setData(T data) {
        this.data = data;
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
