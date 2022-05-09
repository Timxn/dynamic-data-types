package inc.boes.praktikum.classes.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isEmpty() {
        Stack<Integer> integerStack = new Stack<>();
        assertTrue(integerStack.isEmpty());
        integerStack.push(42);
        assertFalse(integerStack.isEmpty());
    }

    @Test
    void pushRandom() {
        int randomValue = (int)(Math.random()*Integer.MAX_VALUE);
        if (Math.random()< 0.5) randomValue *= -1;
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(randomValue);
        assertFalse(integerStack.isEmpty());
    }

    @Test
    void pushNull() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(null);
        assertFalse(integerStack.isEmpty());
    }


    @Test
    void pop() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(42);
        integerStack.pop();
        assertTrue(integerStack.isEmpty());
    }

    @Test
    void popOnEmptyStack() {
        Stack<Integer> integerStack = new Stack<>();
        assertThrows(EmptyStackException.class, integerStack::pop);
    }

    @Test
    void pushAndPop() {
        Stack<Integer> integerStack = new Stack<>();
        int randomValue = (int)(Math.random()*Integer.MAX_VALUE);
        if (Math.random()< 0.5) randomValue *= -1;
        integerStack.push(randomValue);
        assertEquals(randomValue, integerStack.pop());
        assertTrue(integerStack.isEmpty());
        integerStack.push(null);
        assertFalse(integerStack.isEmpty());
    }

    @Test
    void top() {
        int randomValue = (int)(Math.random()*Integer.MAX_VALUE);
        if (Math.random()< 0.5) randomValue *= -1;
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(randomValue);
        assertEquals(randomValue, integerStack.top());
    }

    @Test
    void hasNext() {
        Stack<Integer> integerStack = new Stack<>();
        assertThrows(EmptyStackException.class, () -> integerStack.iterator().hasNext());
        integerStack.push(42);
        assertFalse(integerStack.iterator().hasNext());
        integerStack.push(42);
        assertTrue(integerStack.iterator().hasNext());
    }

    @Test
    void next() {
        Stack<Integer> integerStack = new Stack<>();
        assertThrows(NoSuchElementException.class, () -> integerStack.iterator().next());
        integerStack.push(42);
        assertEquals(null, integerStack.iterator().next());
        integerStack.push(42);
        integerStack.push(42);
        assertEquals(42, integerStack.iterator().next());
    }

    @Test
    void removeOnEmptyStack() {
        Stack<Integer> integerStack = new Stack<>();
        assertThrows(EmptyStackException.class, () -> integerStack.iterator().remove());
    }

    @Test
    void remove() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(42);
        integerStack.iterator().remove();
        assertTrue(integerStack.isEmpty());
    }

    @Test
    void removeInMultipleElementStack() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(42);
        integerStack.push(43);
        integerStack.push(44);
        Iterator<Integer> iterator = integerStack.iterator();
        iterator.next();
        iterator.remove();
        integerStack.pop();
        assertEquals(42, integerStack.pop());
    }
}