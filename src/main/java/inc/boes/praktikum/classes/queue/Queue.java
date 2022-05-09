package inc.boes.praktikum.classes.queue;

import inc.boes.praktikum.interfaces.AbstractQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements AbstractQueue<T>,Iterable<T> {
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private int size = 0;

    public Queue() {
    }

    @Override
    public void enqueue(T data) {
        if (head == null) {
            head = new QueueNode<>(data);
            tail = head;
        } else {
            QueueNode<T> temp = new QueueNode<>(data);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }


    /**
     * @throws NoSuchElementException if queue is empty
     * @return returns the removed element
     */
    @Override
    public T dequeue() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            QueueNode<T> tmp = head;
            if (tail.equals(head)) {
                head = null;
                tail = null;
            } else {
                head = tmp.getNext();
            }
            tmp.setNext(null);
            size--;
            return tmp.getContent();
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<>(this, head, tail);
    }

    public class QueueNode<T> {
        private T content;
        private QueueNode<T> next;

        public QueueNode(T content) {
            this.content = content;
            this.next = null;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public QueueNode<T> getNext() {
            return next;
        }

        public void setNext(QueueNode<T> next) {
            this.next = next;
        }
    }

    public class QueueIterator<T> implements Iterator<T> {
        private Queue<T> original_queue;
        private QueueNode<T> iterator_head, iterator_tail;
        private int position = 0;
        private boolean hasMovedSinceLastDelete = true;

        public QueueIterator(Queue<T> original_queue, QueueNode iterator_head, QueueNode iterator_tail) {
            this.original_queue = original_queue;
            this.iterator_head = iterator_head;
            this.iterator_tail = iterator_tail;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @throws NoSuchElementException if the queue
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (head == null) {
                throw new NoSuchElementException("Queue is empty");
            } else if (iterator_head.equals(iterator_tail)) {
                return false;
            } else return true;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (iterator_head.equals(iterator_tail)) {
                throw new NoSuchElementException();
            }
            iterator_head = iterator_head.getNext();
            position++;
            hasMovedSinceLastDelete = true;
            return iterator_head.getContent();
        }
    }
}
