package inc.boes.praktikum.classes;

import static org.junit.jupiter.api.Assertions.*;

import inc.boes.praktikum.classes.lists.SingleLinkedList;
import org.junit.jupiter.api.* ;

import java.util.Iterator;

class SinglyLinkedListTest {

    @Test
    void add() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        assertTrue(intsingleLinkedList.isEmpty());
        intsingleLinkedList.add(5);
        assertFalse(intsingleLinkedList.isEmpty());
    }

    @Test
    void insertAfter() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int value = (int)(Math.random()*Integer.MAX_VALUE);
        intsingleLinkedList.insertafter(value ,2);
        assertEquals(value, intsingleLinkedList.getNode(3));
    }

    @Test
    void removeLast() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.removeLast();
        assertEquals(intsingleLinkedList.getSize(),2);
    }

    @Test
    void removeatPointer() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int temp = (int)(Math.random()*Integer.MAX_VALUE);
        intsingleLinkedList.add(temp);
        intsingleLinkedList.removeatPointer(2);
        assertEquals(temp, intsingleLinkedList.getNode(2));

    }


    @Test
    void removeNode() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int temp = (int)(Math.random()*Integer.MAX_VALUE);
        intsingleLinkedList.add(temp);
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.removeNode(2);
        assertEquals(temp, intsingleLinkedList.getNode(2));
    }

    @Test
    void removeNodes() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add(5);
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add(5);
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add(5);
        System.out.println(intsingleLinkedList);
        intsingleLinkedList.removeNodes(5);
        System.out.println(intsingleLinkedList);
        assertEquals(3, intsingleLinkedList.getSize());

    }

    @Test
    void getNode() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int value = (int)(Math.random()*Integer.MAX_VALUE);
        intsingleLinkedList.add((int)(value));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        assertEquals(value, intsingleLinkedList.getNode(2));
    }

    @Test
    void getSize() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        intsingleLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        assertEquals(3, intsingleLinkedList.getSize());
    }

    @Test
    void iterator() {
        SingleLinkedList<Integer> intsingleLinkedList = new SingleLinkedList<>();
        intsingleLinkedList.add(5);
        intsingleLinkedList.add(3);
        intsingleLinkedList.add(8);
        intsingleLinkedList.add(7);
        Iterator<Integer> iterator = intsingleLinkedList.iterator();
        assertTrue((iterator != null));
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertEquals(3, iterator.next());
    }
}