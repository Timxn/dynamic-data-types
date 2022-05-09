package inc.boes.praktikum.classes.stack;

import inc.boes.praktikum.interfaces.AbstractStack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements AbstractStack<T>, Iterable<T> {
    private int size;
    private Stack_Node<T> root;

    /**
     * Build a Stack with one Element with the sepcified content
     * @param content expects generic data to be stored in root (first and only node) of a new stack
     *
     */
    public Stack(T content) {
        this.size = 1;
        this.root = new Stack_Node<>(content);
    }


    /**
     * Build empty Stack
     */
    public Stack() {
        this.size = 0;
        this.root = null;
    }


    /**
     * add data to Stack
     * @param content expects generic data to be stored in new root node (on top of stack)
     */
    @Override
    public void push(T content) {
        Stack_Node newNode = new Stack_Node(content);
        newNode.setNext(root);
        root = newNode;
        size++;
    }


    /**
     * remove last inserted element and return it
     * @return null if stack is empty, else generic data type stored in the root node
     */
    @Override
    public T pop() {
        if (root != null) {
            T temp = root.getContent();
            if (size > 1) {
                root = root.getNext();
            } else {
                root = null;
            }
            size--;
            return temp;
        } else {
            throw new EmptyStackException();
        }
    }


    /**
     * return last inserted element
     * @return null if stack is empty, else generic data type stored in the root node
     */
    @Override
    public T top() {
        if (root != null) {
            return (T) root.getContent();
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (root == null) return true;
        return false;
    }


    /**
     * toString() function for representation of Stack
     * @return ['numberOfElement'] contains 'content' | ... | ['numberOfElement'] contains 'content'
     */

    @Override
    public String toString() {
        if (root == null) {
            return "Stack is empty";
        } if (size == 1) {
            return "[0] contains " + root.getContent();
        }
        Stack_Node tempNode = root;
        String output = "";
        int counter = 0;
        while (counter < size-1) {          // -1 needed as in code an Stack with 1 element has a size of 1, while beeing represented in Output as position 0
            output = output + "[" + counter + "] contains " + tempNode.getContent() + " | " ;
            tempNode = tempNode.getNext();
            counter++;
        }
        output = output + "[" + counter + "] contains " + tempNode.getContent();
        return output;
    }

    public void deleteAtPosition(int position) {
        Stack_Node<T> temp = root;
        if (root == null) {
            throw new EmptyStackException();
        }
        if (position == 0) {
            root = temp.getNext();
        } else {
            for (int i = 0; i < position-1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public StackIterator<T> iterator() {
        return new StackIterator<>(root, this);
    }

    public class StackIterator<T> implements Iterator<T> {
        private Stack<T> root;
        private Stack_Node<T> current;
        private int position = 0;
        private boolean hasMovedSinceLastDelete = true;

        public StackIterator(Stack_Node<T> current, Stack<T> pStack) {
            this.current = current;
            this.root = pStack;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (current == null) {
                throw new EmptyStackException();
            }
            if (current.getNext() == null) {
                return false;
            }
            return true;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            } else {
                position++;
                hasMovedSinceLastDelete = true;
                current = current.getNext();
                if (current == null) {
                    return null;
                } else {
                    return current.getContent();
                }
            }
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            if (hasMovedSinceLastDelete) {
                root.deleteAtPosition(position);
                hasMovedSinceLastDelete = false;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
