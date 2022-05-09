package inc.boes.praktikum.classes.lists;

import inc.boes.praktikum.interfaces.AbstractSinglyLinkedList;

public class SingleLinkedList<T extends Comparable> implements AbstractSinglyLinkedList<T> {
    private SingleLinkedListNode root;

    public SingleLinkedList(T data) {
        this.root = new SingleLinkedListNode<>(data);
    }

    /**
     * This function adds the data given at the end of the list.
     * @param pData what data to add
     */
    @Override
    public void add(T pData) {
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
        SingleLinkedListNode current = root;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    /**
     * This function removes a Node from the given index location
     * @param pointer index specifies the location inside the list
     */
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

    /**
     * This function removes the first node containing the given Data
     * @param Node pData contains the generic Datatype whose first occurrence shall be removed
     */
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

    /**
     * This function removes all occurrences of the given Data
     * @param Node pData contains the generic Datatype whose occurrences shall be removed
     */
    @Override
    public void removeNodes(T Node) {
        while (root.findPointerof(Node)) {
            root.removeatPointer(root.findPointerof(Node));
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
        while (index != 0) {
            current = current.getNext();
            index--;
        }
        return current.getData();
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
     * @param Node provides the data whose indexes we want
     * @return returns an int[] with all positions of all occurences
     */
    @Override
    public int[] findPointersof(T Node) {
        SingleLinkedListNode current = root;
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
}
