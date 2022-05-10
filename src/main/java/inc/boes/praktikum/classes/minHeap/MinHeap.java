package inc.boes.praktikum.classes.minHeap;

import inc.boes.praktikum.classes.lists.SingleLinkedList;
import inc.boes.praktikum.interfaces.AbstractMinHeap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable> implements AbstractMinHeap<T>, Comparator<T> {

    SingleLinkedList<T> minHeap = new SingleLinkedList<>();


    /**
     *
     * @param o1
     * @param o2
     * @return 1 wenn o1 > o2 ist, 0 wenn o1 = o2 ist und -1 wenn o1 < o2 ist
     */
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }


    /**
     *
     * @param position is the current position of the node which parents position we want
     * @return return position of parent node
     *
     */
    private int parent(int position) { return (position-1) / 2; }


    /**
     *
     * @param position is the current position of the node which left childs position we want
     * @return return position of left child, same position as input if it has no child
     *
     */
    private int leftChild(int position) {
        if(position*2 > minHeap.getSize()-1){
            return position;
        }
        return (2 * position);
    }


    /**
     *
     * @param position is the current position of the node which right childs position we want
     * @return return position of right child, same position as input if it has no child
     *
     */
    private int rightChild(int position) {
        if ((2 * position) + 1 > minHeap.getSize()-1){
            return position;
        }
        return (2 * position) + 1;
    }


    /**
     *
     * Swaps the nodes placed in the firstPosition and the secondPosition
     * @param firstPosition is the position of the first node
     * @param secondPosition is the position of the second node
     *
     */
    private void swap(int firstPosition, int secondPosition){
        T placeholder;
        placeholder = minHeap.getNode(firstPosition);
        this.update(minHeap.getNode(secondPosition),firstPosition);
        this.update(placeholder,secondPosition);
    }

    /**
     *
     * @param value
     * @throws NullPointerException when value is null
     */
    @Override
    public void insert(T value){
        if (value == null) {
            throw new NullPointerException();
        }
        if(minHeap.getSize() == 0){
            minHeap.add(value);
        }else{
            minHeap.add(value);
            int current = minHeap.getSize()-1;
            while(compare(minHeap.getNode(parent(current)), minHeap.getNode(current)) > 0){
                swap(current,parent(current));
                current = parent(current);
            }
        }
    }

    /**
     *
     * changes the value at a given key
     * @param key the position at wich te data shall be changedwwwww
     *
     */
    private void update(T object, int key) {
        if(minHeap.getNode(0)==null) throw new IndexOutOfBoundsException();
        minHeap.removeatPointer(0);
        minHeap.insertafter(object,0);

    }

    /**
     *
     *
     *
     *
     */
    @Override
    public void delete(T value){
        //checks if value exists in List
        int current = minHeap.findPointerof(value);
        if (current == -1) {
            throw new NoSuchElementException();
        }

        this.update(minHeap.getNode(minHeap.getSize()-1), current);
        minHeap.removeLast();
        while(compare(minHeap.getNode(parent(current)),minHeap.getNode(current)) > 0){
            swap(current,parent(current));
            current = parent(current);
        }
        while(compare(minHeap.getNode(current),minHeap.getNode(leftChild(current))) > 0 || compare(minHeap.getNode(current),minHeap.getNode(rightChild(current))) > 0) {
            if(compare(minHeap.getNode(current),minHeap.getNode(leftChild(current))) > 0){
                //if node is a leaf stop
                if (leftChild(current) > minHeap.getSize()){
                    break;
                }
                swap(current,leftChild(current));
                current = leftChild(current);
            }else if(compare(minHeap.getNode(current),minHeap.getNode(rightChild(current))) > 0){
                //if node is a leaf stop
                if (rightChild(current) > minHeap.getSize()){
                    break;
                }
                swap(current,rightChild(current));
                current = rightChild(current);
            }
        }
    }

    /**
     * returns the lowest element and removes it
     * @return lowest Element
     *
     */
    @Override
    public T getMin() {
        T tmp = minHeap.getNode(0);
        minHeap.removeatPointer(0);
        return tmp;
    }

    /**
     *
     * @param value
     * @return true if value exists
     */
    @Override
    public boolean exists(T value){
        for(int i = 0; i < minHeap.getSize();i++){
            if(compare(value,minHeap.getNode(i)) == 0){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty(){
        if (minHeap.getSize() == 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString(){
        StringBuilder stringMinHeap = new StringBuilder("min Heap: ");
        for(int i = 0; i < minHeap.getSize()-1; i++){
            stringMinHeap.append(minHeap.getNode(i)).append(", ");
        }
        stringMinHeap.append(minHeap.getNode(minHeap.getSize() - 1)).append(".");
        return stringMinHeap.toString();
    }
}

