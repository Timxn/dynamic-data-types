package inc.boes.praktikum.classes;

import inc.boes.praktikum.classes.minHeap.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void compare() {
        MinHeap<Integer> heap = new MinHeap<>();
        assertEquals(1, heap.compare(24,1));
        assertEquals(-1, heap.compare(1,24));
        assertEquals(0, heap.compare(1,1));
    }

    @Test
    void insert() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert((int)(Math.random()*Integer.MAX_VALUE));
        assertFalse(heap.isEmpty());
        MinHeap<Integer> emptyHeap = new MinHeap<>();
        assertThrows(NullPointerException.class, () -> emptyHeap.insert(null));
    }

    @Test
    void delete() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(42);
        heap.delete(42);
        assertTrue(heap.isEmpty());

    }

    @Test
    void exists() {
    }
}
