package inc.boes.praktikum.classes.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListIterator <T> implements Iterator<T>{
    DoublyLinkedListNode<T> current = null;
    DoublyLinkedListNode<T> head = null;

    public DoublyLinkedListIterator(DoublyLinkedListNode<T> current) {
        this.current = current;
        this.head = current;
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
        if ( current == null && head != null){
            current = head;
            return head.getData();
        }
        else if (current != null){

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
