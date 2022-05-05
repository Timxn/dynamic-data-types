package inc.boes.praktikum.classes.lists;

import java.util.Iterator;

public class DoublyLinkedListIterator <T> implements Iterator<T>{
Node<T> current = null;

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
                return head.getElement();
            }
            else if (current != null){

                current = current.getNext();
                return current.getElement();
            }
            throw new nosuchElementException();
        }

    @Override
        public void remove (){
        throw new UnsupportedOperationException();
    }
}
