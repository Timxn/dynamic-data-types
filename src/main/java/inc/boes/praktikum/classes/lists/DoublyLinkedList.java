package inc.boes.praktikum.classes.lists;

import inc.boes.praktikum.interfaces.AbstractDoublyLinkedList;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T extends Comparable> implements AbstractDoublyLinkedList<T>, Iterable<T> {
    private DoublyLinkedListNode root;
    private int size = 0;

    public DoublyLinkedList(T pData) {
        this.root = new DoublyLinkedListNode<>(pData);
        this.size = 1;
    }

    /**
     * This function adds the data given at the end of the list.
     * @param pData what data to add
     */
    @Override
    public void add(T pData) {
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new DoublyLinkedListNode<>(pData, current));
    }


    /**
     * This function places the data given after the given location inside the list. It does so by creating a new node and pushing existing nodes one to the back.
     * @param pData what data to be inserted
     * @param index where to insert it (if it shall be placed at the second place ([0,1,2,...] so index 1) in this case)
     * @throws IndexOutOfBoundsException when index points to non existing Element
     */
    @Override
    public void insertAfter(T pData, int index) {
        if ( index > size ){
            throw new IndexOutOfBoundsException();
        }
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

    /**
     * This function removes the last Node from the list.
     * @throws NoSuchElementException when List is empty
     */
    @Override
    public void removeLast() {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.getPrevious().setNext(null);
        current.setPrevious(null);
    }

    /**
     * This function removes a Node from the given index location
     * @param index index specifies the location inside the list
     * @throws NoSuchElementException when List is empty
     * @throws IndexOutOfBoundsException when index points to non existing Element
     */
    @Override
    public void removeNode(int index) {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedListNode current = root;
        while (index > 1) {
            current = current.getNext();
            index--;
        }
        if (current.getNext() != null) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        } else {
            current.setNext(null);
            current.setPrevious(current.getPrevious());
        }
        size--;
    }

    /**
     * This function removes the first node containing the given Data
     * @param pData pData contains the generic Datatype whose first occurrence shall be removed
     * @throws NoSuchElementException when List is empty
     */
    @Override
    public void removeValue(T pData) {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        int position = this.getPositionOfValue(pData);
        if (position != -1) {
            this.removeNode(position);
        }
    }

    /**
     * This function removes all occurrences of the given Data
     * @param pData pData contains the generic Datatype whose occurrences shall be removed
     * @throws NoSuchElementException when List is empty
     */
    @Override
    public void removeAllOfThisValues(T pData) {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        while (this.getPositionOfValue(pData) != -1) {
            this.removeNode(this.getPositionOfValue(pData));
        }
    }

    /**
     * This function provides us with a tool to retrieve the data from a given position in this List
     * @param index index ist the position whose data is of interest
     * @return This function returns a generic datatype extending comparable
     * @throws IndexOutOfBoundsException when index points to non existing Element
     */
    @Override
    public T getValue(int index) {
        if (index > size ){
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedListNode current = root;
        while (index != 0) {
            current = current.getNext();
            index--;
        }
        return (T) current.getData();
    }

    /**
     * This function provides us with the ability to find the first occurrence of the specified data
     * @param pData
     * @return returns >= 0 if found or -1 if no Node with provided Data is found
     * @throws NoSuchElementException if List is empty
     */
    @Override
    public int getPositionOfValue(T pData) {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        DoublyLinkedListNode current = root;
        int position = 0;
        while (current != null) {
            if (current.getData() == pData) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }

    /**
     * This function provides us with a list (array) of all indexes at which a specific entry is located
     * @param pData
     * @return returns an int[] with all positions of all occurences
     * @throws NoSuchElementException if List is empty
     */
    @Override
    public int[] getAllPositionsOfValue(T pData) {
        if (root.equals(null)){
            throw new NoSuchElementException();
        }
        DoublyLinkedListNode current = root;
        ArrayList<Integer> results = new ArrayList<>();
        int position = 0;
        while (current.getNext() != null) {
            if (current.getData().equals(pData)) {
                results.add(position);
            }
            current = current.getNext();
            position++;
        }
        if (current.getData().equals(pData)) {
            results.add(position);
        }
        int[] resultsOut = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultsOut[i] = results.get(i);
        }
        return resultsOut;
    }

    public int getSize() {
        return size;
    }

    @Override
    public DoublyLinkedListIterator<T> iterator() {
        return new DoublyLinkedListIterator<>(root);
    }

    public boolean isEmpty() {
        if (root.equals(null)) {
            return true;
        }
        return false;
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
        String out = "";
        DoublyLinkedListNode current = root;
        while (current.getNext() != null) {
            out = out + "[ " + current.getData() + " ]" + " | ";
            current = current.getNext();
        }
        out = out + "[ " + current.getData() + " ]";
        return out;
    }
}
