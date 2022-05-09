package inc.boes.praktikum.classes.trees;

import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        assertEquals(3, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
        assertEquals(4, bst.getRoot().getRightChild().getValue().intValue());
        assertEquals(1, bst.getRoot().getLeftChild().getLeftChild().getValue().intValue());
    }

    @Test
    void insertNull(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertThrows(NullPointerException.class, () -> bst.insert(null));
    }

    @Test
    void delete2child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.delete(3);
        assertEquals(4, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
    }

    @Test
    void delete1child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(3);
        bst.delete(2);
        assertEquals(3, bst.getRoot().getValue().intValue());
    }

    @Test
    void delete0child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.delete(4);
        assertEquals(3, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
    }

    @Test
    void deleteNull(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        assertThrows(NullPointerException.class, () -> bst.delete(null));
    }

    @Test
    void search() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        assertTrue(bst.search(1));
        assertFalse(bst.search(2));
    }

    @Test
    void searchNull() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        assertThrows(NullPointerException.class, () -> bst.search(null));
    }

    @Test
    void isEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
        bst.insert(1);
        assertFalse(bst.isEmpty());
    }

    @Test
    void testToStringInOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 1.0 2.0 3.0", bst.toString(AbstractBinarySearchTree.Traversal.InOrder));
    }

    @Test
    void testToStringPreOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 2.0 1.0 3.0", bst.toString(AbstractBinarySearchTree.Traversal.PreOrder));
    }

    @Test
    void testToStringPostOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 1.0 3.0 2.0", bst.toString(AbstractBinarySearchTree.Traversal.PostOrder));
    }

    @Test
    void iterator() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        BinarySearchTree<Integer>.TreeIterator<Integer> it = bst.iterator();
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(1, it.next());
        assertThrows(NoSuchElementException.class, it::next);
        assertFalse(it.hasNext());
    }
}