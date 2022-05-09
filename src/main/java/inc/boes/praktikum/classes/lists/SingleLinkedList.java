package inc.boes.praktikum.classes.lists;

import inc.boes.praktikum.interfaces.AbstractSinglyLinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements AbstractSinglyLinkedList<T>, Iterable<T> {
    private SingleLinkedListNode<T> root;
    private int size = 0;

    public SingleLinkedList(T data) {
        this.root = new SingleLinkedListNode<>(data);
        this.size = 1;
    }

    public SingleLinkedList() {};

    /**
     * This function adds the data given at the end of the list.
     * @param pData what data to add
     */
    @Override
    public void add(T pData) {
        size++;
        SingleLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new SingleLinkedListNode(pData));
    }

    /**
     * This function places the data given after the given location inside the list. It does so by creating a new node and pushing existing nodes one to the back.
     * @param Node what data to be inserted
     * @param index where to insert it (if it shall be placed at the second place ([0,1,2,...] so index 1) in this case)
     */
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

    /**
     * This function removes the last Node from the list.
     */
    @Override
    public void removeLast() {
        if (root.equals(null)) {
            throw new NoSuchElementException();
        }
        SingleLinkedListNode current = root;
        if (root.getNext().equals(null)) {
            root = null;
            size--;
            return;
        } else {
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            size--;
        }
    }

    /**
     * This function removes a Node from the given index location
     * @param pointer index specifies the location inside the list
     */
    @Override
    public void removeatPointer(int pointer) {
        SingleLinkedListNode current = root;
        while (pointer > 1) {
            current = current.getNext();
            pointer--;
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;
    }

    /**
     * This function removes the first node containing the given Data
     * @param Node pData contains the generic Datatype whose first occurrence shall be removed
     */
    @Override
    public void removeNode(T Node) {
        SingleLinkedListNode current = root;
        while (!current.getNext().getData().equals(Node)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;
    }

    /**
     * This function removes all occurrences of the given Data
     * @param Node pData contains the generic Datatype whose occurrences shall be removed
     */
    @Override
    public void removeNodes(T Node) {
        while (this.findPointerof(Node) != -1) {
            this.removeatPointer(this.findPointerof(Node));
        }
    }

    /**
     * This function provides us with a tool to retrieve the data from a given position in this List
     * @param pointer index ist the position whose data is of interest
     * @return This function returns a generic datatype extending comparable
     */
    @Override
    public T getNode(int pointer) {
        SingleLinkedListNode current = root;
        while (pointer != 0) {
            current = current.getNext();
            pointer--;
        }
        return (T) current.getData();
    }

    /**
     * This function provides us with the ability to find the first occurrence of the specified data
     * @param Node provides the data whose index we want
     * @return returns >= 0 if found or -1 if no Node with provided Data is found
     */
    @Override
    public int findPointerof(T Node) {
        SingleLinkedListNode current = root;
        int position = 0;
        while (current.getNext() != null) {
            if (current.getData() == Node) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    /**
     * This function provides us with a list (array) of all indexes at which a specific entry is located
     * @param Node provides the data whose indexes we want
     * @return returns an int[] with all positions of all occurences
     */
    @Override
    public int[] findPointersof(T Node) {
        SingleLinkedListNode current = root;
        SingleLinkedList<Integer> results = new SingleLinkedList<>();
        int position = 0;
        while (current.getNext() != null) {
            if (current.getData().equals(Node)) {
                results.add(position);
            }
            current = current.getNext();
            position++;
        }
        if (current.getData().equals(Node)) {
            results.add(position);
        }
        int[] resultsOut = new int[results.getSize()];
        for (int i = 0; i < results.getSize(); i++) {
            resultsOut[i] = results.getNode(i);
        }
        return resultsOut;
    }

    /**
     *
     * !!! Unoptimized, if used with larger Lists use Stringbuilder !!!
     *
     * This function provides us with the ability to visually represent our list
     * @return returns a string
     */
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
    /**
     * For the Iterator
     *
     *
     *
     */
    @Override
    public Iterator<T> iterator(){
        return new SinglyLinkedListsIterator(root);
    }
}
