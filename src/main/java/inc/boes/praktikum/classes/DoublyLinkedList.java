package inc.boes.praktikum.classes;

import inc.boes.praktikum.interfaces.AbstractDoublyLinkedList;

public class DoublyLinkedList<T> implements AbstractDoublyLinkedList<T> {
    private DoublyLinkedListNode root;

    public DoublyLinkedList(T pData) {
        this.root = new DoublyLinkedListNode<>(pData);
    }

    @Override
    public void add(T pData) {
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new DoublyLinkedListNode<>(pData, current));
        System.out.println(pData);
    }

    @Override
    public void insertAfter(T pData, int index) {
        DoublyLinkedListNode current = root;
        while (index != 0) {
            current = current.getNext();
            index--;
        }
        DoublyLinkedListNode toBeAdded = new DoublyLinkedListNode(pData);
        toBeAdded.setPrevious(current);
        if (current.getNext() != null) {
            current.getNext().setPrevious(toBeAdded);
            toBeAdded.setNext(current.getNext());
        }
        current.setNext(toBeAdded);
    }

    @Override
    public void removeLast() {
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.getPrevious().setNext(null);
        current.setPrevious(null);
    }

    @Override
    public void removeNode(int index) {
    }

    @Override
    public void removeValue(T Node) {

    }

    @Override
    public void removeAllOfThisValues(T Node) {

    }

    @Override
    public T getValue(int pointernext) {
        return null;
    }

    @Override
    public int getPositionOfValue(T Node) {
        return 0;
    }

    @Override
    public int[] getAllPositionsOfValue(T Node) {
        return new int[0];
    }

    @Override
    public String toString() {
        String out = "";
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            out = out + "[ " + current.getData() + " ]" + " | ";
            System.out.println(current.getData());
            current = current.getNext();
        }
        out = out + "[ " + current.getData() + " ]";
        return out;
    }
}
