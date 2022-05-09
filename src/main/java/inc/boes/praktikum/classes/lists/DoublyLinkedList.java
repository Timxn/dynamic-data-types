package inc.boes.praktikum.classes.lists;

import inc.boes.praktikum.interfaces.AbstractDoublyLinkedList;

import java.util.ArrayList;

public class DoublyLinkedList<T extends Comparable> implements AbstractDoublyLinkedList<T>, Iterable<T> {
    private DoublyLinkedListNode root;

    public DoublyLinkedList(T pData) {
        this.root = new DoublyLinkedListNode<>(pData);
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
     */
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

    /**
     * This function removes the last Node from the list.
     */
    @Override
    public void removeLast() {
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
     */
    @Override
    public void removeNode(int index) {
        DoublyLinkedListNode current = root;
        while (index != 0) {
            current = current.getNext();
            index--;
        }
        if (current.getNext() != null) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        current.setNext(null);
        current.setPrevious(null);
    }

    /**
     * This function removes the first node containing the given Data
     * @param pData pData contains the generic Datatype whose first occurrence shall be removed
     */
    @Override
    public void removeValue(T pData) {
        int position = this.getPositionOfValue(pData);
        if (position != -1) {
            this.removeNode(position);
        }
    }

    /**
     * This function removes all occurrences of the given Data
     * @param pData pData contains the generic Datatype whose occurrences shall be removed
     */
    @Override
    public void removeAllOfThisValues(T pData) {
        while (this.getPositionOfValue(pData) != -1) {
            this.removeValue(pData);
        }
    }

    /**
     * This function provides us with a tool to retrieve the data from a given position in this List
     * @param index index ist the position whose data is of interest
     * @return This function returns a generic datatype extending comparable
     */
    @Override
    public T getValue(int index) {
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
     */
    @Override
    public int getPositionOfValue(T pData) {
        DoublyLinkedListNode current = root;
        int position = 0;
        while (current.getNext() != null) {
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
     */
    @Override
    public int[] getAllPositionsOfValue(T pData) {
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

    @Override
    public DoublyLinkedListIterator<T> iterator() {
        return new DoublyLinkedListIterator<>(root);
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
