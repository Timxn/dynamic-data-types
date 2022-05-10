package inc.boes.praktikum.classes;

import inc.boes.praktikum.classes.trees.BinarySearchTree;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    /**
     * checks whether insertion of multiple values works
     */
    @Test
    void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        assertEquals(3, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
        assertEquals(4, bst.getRoot().getRightChild().getValue().intValue());
        assertEquals(1, bst.getRoot().getLeftChild().getLeftChild().getValue().intValue());
    }

    /**
     * inserts null value
     */
    @Test
    void insertNull(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        assertThrows(NullPointerException.class, () -> bst.insert(null));
    }

    /**
     * checks if deletion of a node which has a left and a right child works
     */
    @Test
    void delete2child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.delete(3);
        assertEquals(4, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
    }

    /**
     * checks if deletion of a node which has only one child works
     */
    @Test
    void delete1child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(2);
        bst.insert(3);
        bst.delete(2);
        assertEquals(3, bst.getRoot().getValue().intValue());
    }

    /**
     * checks if deletion of a node without children works
     */
    @Test
    void delete0child() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.delete(4);
        assertEquals(3, bst.getRoot().getValue().intValue());
        assertEquals(2, bst.getRoot().getLeftChild().getValue().intValue());
    }

    /**
     * deletes null from the tree
     */
    @Test
    void deleteNull(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(1);
        assertThrows(NullPointerException.class, () -> bst.delete(null));
    }

    /**
     * checks whether searching an element works
     */
    @Test
    void search() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(1);
        assertTrue(bst.search(1));
        assertFalse(bst.search(2));
    }

    /**
     * searches null
     */
    @Test
    void searchNull() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(1);
        assertThrows(NullPointerException.class, () -> bst.search(null));
    }

    /**
     * checks if the isEmpty method works
     */
    @Test
    void isEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        assertTrue(bst.isEmpty());
        bst.insert(1);
        assertFalse(bst.isEmpty());
    }

    /**
     * checks if toString with traversal inorder works
     */
    @Test
    void testToStringInOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 1 2 3", bst.toString(AbstractBinarySearchTree.Traversal.InOrder));
    }

    /**
     * checks if toString with traversal preorder works
     */
    @Test
    void testToStringPreOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 2 1 3", bst.toString(AbstractBinarySearchTree.Traversal.PreOrder));
    }

    /**
     * checks if toString with traversal postorder works
     */
    @Test
    void testToStringPostOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        assertEquals(" 1 3 2", bst.toString(AbstractBinarySearchTree.Traversal.PostOrder));
    }

    /**
     * checks if every function in the iterator works probably
     */
    @Test
    void iterator() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
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