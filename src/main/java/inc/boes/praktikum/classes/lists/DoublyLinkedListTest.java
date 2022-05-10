package inc.boes.praktikum.classes.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    /*
    * Same as with singlylinkedlists
    */
    @Test
    void add() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        assertTrue(integerDoublyLinkedList.isEmpty());
        integerDoublyLinkedList.add(5);
        assertFalse(integerDoublyLinkedList.isEmpty());
    }

    @Test
    void insertAfter() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int value = (int)(Math.random()*Integer.MAX_VALUE);
        integerDoublyLinkedList.insertAfter(value ,2);
        assertEquals(value, integerDoublyLinkedList.getValue(3));
    }

    @Test
    void removeLast() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.removeLast();
        assertEquals(integerDoublyLinkedList.getSize(),2);
    }

    @Test
    void removeNode() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int temp = (int)(Math.random()*Integer.MAX_VALUE);
        integerDoublyLinkedList.add(temp);
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        System.out.println(integerDoublyLinkedList);
        integerDoublyLinkedList.removeNode(2);
        assertEquals(2, integerDoublyLinkedList.getSize());
    }

    @Test
    void removeValue() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        int temp = (int)(Math.random()*Integer.MAX_VALUE);
        integerDoublyLinkedList.add(temp);
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.removeValue(3);
        assertEquals(temp, integerDoublyLinkedList.getValue(3));
    }

    @Test
    void removeAllOfThisValues() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add(5);
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add(5);
        integerDoublyLinkedList.add((int)(Math.random()*Integer.MAX_VALUE));
        integerDoublyLinkedList.add(5);
        System.out.println(integerDoublyLinkedList);
        integerDoublyLinkedList.removeAllOfThisValues(5);
        System.out.println(integerDoublyLinkedList);
        assertEquals(3, integerDoublyLinkedList.getSize());
    }

    @Test
    void getValue() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void getPositionOfValue() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void getAllPositionsOfValue() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void getSize() {
    }DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();

    @Test
    void iterator() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void isEmpty() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void testToString() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
    }
}