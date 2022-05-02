package inc.boes.praktikum.classes;

import inc.boes.praktikum.interfaces.AbstractSinglyLinkedList;

public class SingleLinkedList<T extends Comparable> implements AbstractSinglyLinkedList<T> {
    private SingleLinkedListNode root;

    public SingleLinkedList(T data) {
        this.root = new SingleLinkedListNode<>(data);
    }

    @Override
    public void add(T pData) {
        SingleLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new SingleLinkedListNode(pData));
    }

    @Override
    public void insertafter(T Node, int index) {
        SingleLinkedListNode current = root;
        while (index != 0) {
            current = current.getNext();
            index--;
        }
        SingleLinkedListNode toBeAdded = new SingleLinkedListNode(Node);
        if (current.getNext() != null) {
            toBeAdded.setNext(current.getNext());
        }
        current.setNext(toBeAdded);
    }

    @Override
    public void removeLast() {

    }

    @Override
    public void removeatPointer(int pointer) {

    }

    @Override
    public void removeNode(T Node) {

    }

    @Override
    public void removeNodes(T Node) {

    }

    @Override
    public T getNode(int pointer) {
        return null;
    }

    @Override
    public int findPointerof(T Node) {
        return 0;
    }

    @Override
    public int[] findPointersof(T Node) {
        return new int[0];
    }

    @Override
    public String toString() {
        SingleLinkedListNode current = root;
        String out = "";
        while (current.getNext() != null) {
            out = out + current.getData() + " | ";
            current = current.getNext();
        }
        out = out + current.getData();
        return out;
    }
}
