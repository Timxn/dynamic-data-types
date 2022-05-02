package inc.boes.praktikum.classes;

import inc.boes.praktikum.interfaces.AbstractSinglyLinkedList;

public class SingleLinkedList<T> implements AbstractSinglyLinkedList<T> {
    private T data;
    private SingleLinkedList next;

    public SingleLinkedList(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public void add(T Node) {

    }

    @Override
    public void insertafter(T Node, int pointer) {

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
}
