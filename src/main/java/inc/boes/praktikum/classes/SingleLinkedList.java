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
        SingleLinkedListNode current = root;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    @Override
    public void removeatPointer(int pointer) {
        SingleLinkedListNode current = root;
        while (index > 1) {
            current = current.getNext();
            index--;
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext.getNext);
        } else {
            current.setNext(null);
        }
    }

    @Override
    public void removeNode(T Node) {
        SingleLinkedListNode current = root;
        while (!current.getNext().getData().equal(Node)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext.getNext);
        } else {
            current.setNext(null);
        }
    }

    @Override
    public void removeNodes(T Node) {
        while (root.findPointerof(Node)) {
            root.removeatPointer(root.findPointerof(Node));
        }
    }

    @Override
    public T getNode(int pointer) {
        return null;
    }

    @Override
    public int findPointerof(T Node) {
        SingleLinkedListNode current = root;
        int index = 0;
        while (!(current.getData().equal(Node))) {
            current = current.getNext();
            index++;
        }
        return index;
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
