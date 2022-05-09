package inc.boes.praktikum.classes.lists;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListsIterator <T> implements Iterator <T> {
    SingleLinkedListNode<T> current = null;
    SingleLinkedListNode<T> head = null;

    public SinglyLinkedListsIterator(SingleLinkedListNode<T> current) {
        this.current = current;
    }


    @Override
    public boolean hasNext(){
        if (current == null && head != null){
            return true;
        }
        else if ( current != null){
            return current.getNext() != null;
        }
        else {
            return false;
        }
    }

    @Override
    public T next(){
//        if ( current == null && head != null){
//            current = head;
//            return head.getData();
//        }
        if (current == null) {
            throw new NoSuchElementException();
        }
        if (current.getNext() != null){
            current = current.getNext();
            return current.getData();
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove (){
        throw new UnsupportedOperationException();
    }

}
