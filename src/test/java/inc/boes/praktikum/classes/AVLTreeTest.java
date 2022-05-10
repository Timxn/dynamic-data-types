package inc.boes.praktikum.classes;

import inc.boes.praktikum.classes.trees.AVLTree;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    /**
     * checks whether insertion of multiple values works
     */
    @Test
    void insert() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(1);
        assertEquals(1, avl.getRoot().getValue().intValue());
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        assertEquals(2, avl.getRoot().getValue().intValue());
    }

    /**
     * inserts null value
     */
    @Test
    void insertNull(){
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        assertThrows(NullPointerException.class, () -> avl.insert(null));
    }

    /**
     * checks if deletion of a node which has a left and a right child works
     */
    @Test
    void delete2child() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.delete(2);
        assertEquals(3, avl.getRoot().getValue().intValue());
    }

    /**
     * checks if deletion of a node which has only one child works
     */
    @Test
    void delete1child() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(2);
        avl.insert(3);
        avl.delete(2);
        assertEquals(3, avl.getRoot().getValue().intValue());
    }

    /**
     * checks if deletion of a node without children works
     */
    @Test
    void delete0child() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(3);
        avl.insert(2);
        avl.insert(4);
        avl.delete(4);
        assertEquals(3, avl.getRoot().getValue().intValue());
        assertEquals(2, avl.getRoot().getLeftChild().getValue().intValue());
    }

    /**
     * deletes null from the tree
     */
    @Test
    void deleteNull(){
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(1);
        assertThrows(NullPointerException.class, () -> avl.delete(null));
    }

    /**
     * checks whether searching an element works
     */
    @Test
    void search() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.delete(2);
        assertTrue(avl.search(1));
        assertFalse(avl.search(2));
        assertTrue(avl.search(3));
        assertTrue(avl.search(4));
    }

    /**
     * searches null
     */
    @Test
    void searchNull() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(1);
        assertThrows(NullPointerException.class, () -> avl.search(null));
    }

    /**
     * checks if the isEmpty method works
     */
    @Test
    void isEmpty() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        assertTrue(avl.isEmpty());
        avl.insert(1);
        assertFalse(avl.isEmpty());
    }

    /**
     * checks if toString with traversal inorder works
     */
    @Test
    void testToStringInOrder() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(2);
        avl.insert(1);
        avl.insert(4);
        avl.insert(5);
        avl.insert(3);
        avl.insert(6);
        assertEquals(" 1 2 3 4 5 6", avl.toString(AbstractBinarySearchTree.Traversal.InOrder));
    }

    /**
     * checks if toString with traversal preorder works
     */
    @Test
    void testToStringPreOrder() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);
        assertEquals(" 2 1 3", avl.toString(AbstractBinarySearchTree.Traversal.PreOrder));
    }

    /**
     * checks if toString with traversal postorder works
     */
    @Test
    void testToStringPostOrder() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);
        assertEquals(" 1 3 2", avl.toString(AbstractBinarySearchTree.Traversal.PostOrder));
    }

    /**
     * checks if every function in the iterator works probably
     */
    @Test
    void iterator() {
        AVLTree<Integer> avl = new AVLTree<>(new IntegerComparator());
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);
        AVLTree<Integer>.TreeIterator<Integer> it = avl.iterator();
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(1, it.next());
        assertThrows(NoSuchElementException.class, it::next);
        assertFalse(it.hasNext());
    }
}