package inc.boes.praktikum.tests;

import inc.boes.praktikum.classes.queue.Queue;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void size() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueNull() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(null);
        assertEquals(1, queue.size());
    }

    @Test
    void enqueue() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(42);
        assertEquals(1, queue.size());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(42);
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    void dequeueOnEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    void iterator() {
        Queue<Integer> queue = new Queue<>();
        Iterator<Integer> emptyIterator = null;
        emptyIterator = queue.iterator();
        assertFalse(emptyIterator.equals(null));
    }

    @Test
    void hasNext() {
        Queue<Integer> queue = new Queue<>();
        Iterator<Integer> emptyIterator = queue.iterator();
        assertThrows(NoSuchElementException.class, () -> emptyIterator.hasNext());
        queue.enqueue(42);
        queue.enqueue(43);
        queue.enqueue(44);
        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void next() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(42);
        queue.enqueue(43);
        queue.enqueue(44);
        Iterator<Integer> iterator = queue.iterator();
        assertEquals(43,iterator.next());
        assertEquals(44,iterator.next());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}