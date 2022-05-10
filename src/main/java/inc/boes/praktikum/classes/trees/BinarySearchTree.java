package inc.boes.praktikum.classes.trees;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Number> implements AbstractBinarySearchTree<T>, Iterable<T>{

    /**
     * root node of the BinarySearchTree
     */
    private TreeNode<T> root;

    /**
     * constructor of BinarySearchTree which sets the root to null
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * method to get the root of the tree
     * @return root_node
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Recursive head for the insertion method
     * @param value which will be inserted
     */
    @Override
    public void insert(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        root = insertion(root, value);
    }

    /**
     * Inserts the given value into the tree at the correct position. If the element exists already nothing happens
     * @param current the TreeNode at which it is looked whether value must be sorted left or right of it
     * @param value which will be inserted
     * @return the subtree after insertion was executed
     */
    private @NotNull TreeNode<T> insertion(TreeNode<T> current, T value) {
        if(existsNode(current)) {
            return new TreeNode<>(value);
        } else if(value.doubleValue() < current.getValue().doubleValue()){
            current.setLeftChild(insertion(current.getLeftChild(), value));
        } else if(value.doubleValue() > current.getValue().doubleValue()){
            current.setRightChild(insertion(current.getRightChild(), value));
        }
        return current; //if element exists already nothing happens and the existing tree will be returned
    }

    /**
     * Recursive head for the deletion method
     * @param value which will be deleted
     */
    @Override
    public void delete(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        root = deletion(root, value);
    }

    /**
     * Deletes the given value from the tree and sets a new child. If the element doesn't exist the tree remains the same
     * @param current the TreeNode at which it is looked whether value is left or right of it
     * @param value which will be deleted
     * @return the subtree after deletion was executed
     */
    private @Nullable TreeNode<T> deletion (TreeNode<T> current, T value) {
        if (existsNode(current)){
            return null;
        }
        if (value.doubleValue() == current.getValue().doubleValue()) {
            if (existsNode(current.getLeftChild()) && existsNode(current.getRightChild())) {
                return null;
            } else if (existsNode(current.getRightChild() )) {
                return current.getLeftChild();
            } else if (existsNode(current.getLeftChild())) {
                return current.getRightChild();
            } else {
                T smallestValue = findSmallestValue(current.getRightChild());
                current.setValue(smallestValue);
                current.setRightChild(deletion(current.getRightChild(), smallestValue));
                return current;
            }
        }
        if (value.doubleValue() < current.getValue().doubleValue()) {
            current.setLeftChild(deletion(current.getLeftChild(), value));
        }
        current.setRightChild(deletion(current.getRightChild(), value));
        return current;
    }

    /**
     * Iterates to the leftmost subtree and returns the value of it
     * @param root is the current subtree
     * @return lowest value
     */
    private T findSmallestValue (@NotNull TreeNode<T> root) {
        return existsNode(root.getLeftChild()) ? root.getValue() : findSmallestValue(root.getLeftChild());
    }

    /**
     * recursive head for the searching method
     * @param value which will be searched
     * @return boolean: is the value in the tree
     */
    @Override
    public boolean search(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return searching(root, value);
    }

    /**
     * Iterates recursive through the tree and checks if the current value is equal to the to be searched value
     * @param current subtree to be looked through
     * @param value which will be searched
     * @return boolean: is the value in this subtree
     */
    private boolean searching(TreeNode<T> current, T value){
        if(existsNode(current)) {
            return false;
        }
        if(value.doubleValue() == current.getValue().doubleValue()) {
            return true;
        }
        return value.doubleValue() < current.getValue().doubleValue()
                ? searching(current.getLeftChild(), value)
                : searching(current.getRightChild(), value);
    }

    /**
     * Method to check if a node exists
     * @param value provided node
     * @return boolean whether not is existent
     */
    private boolean existsNode(TreeNode<T> value) {
        return value == null;
    }

    /**
     * checks whether the tree is empty by looking up if the root has a value
     * @return boolean
     */
    @Override
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * returns the content of the tree as a string sorted by the given order
     * @param traversal determines which order is used
     * @return the created string with all values
     */
    @Override
    public String toString(@NotNull Traversal traversal) {
        switch (traversal) {
            case InOrder -> {
                return traverseInOrder(root, "");
            }
            case PreOrder -> {
                return traversePreOrder(root, "");
            }
            case PostOrder -> {
                return traversePostOrder(root, "");
            }
        }
        return "How did we get here?"; //Unreachable
    }

    /**
     * converts the tree into an inorder traversed string
     * @param node current subtree
     * @param out String so far as parameter to be completed
     * @return String so far with new content
     */
    private String traverseInOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = traverseInOrder(node.getLeftChild(), out);
            out = out + " " + node.getValue().doubleValue();
            out = traverseInOrder(node.getRightChild(), out);
        }
        return out;
    }

    /**
     * converts the tree into a preorder traversed string
     * @param node current subtree
     * @param out String so far as parameter to be completed
     * @return String so far with new content
     */
    private String traversePreOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = out + " " + node.getValue().doubleValue();
            out = traversePreOrder(node.getLeftChild(), out);
            out = traversePreOrder(node.getRightChild(), out);
        }
        return out;
    }

    /**
     * converts the tree into a postorder traversed string
     * @param node current subtree
     * @param out String so far as parameter to be completed
     * @return String so far with new content
     */
    private String traversePostOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = traversePostOrder(node.getLeftChild(), out);
            out = traversePostOrder(node.getRightChild(), out);
            out = out + " " + node.getValue().doubleValue();
        }
        return out;
    }

    /**
     * creates the iterator for the tree
     * @return iterator
     */
    @NotNull
    @Override
    public TreeIterator<T> iterator() {
        return new TreeIterator<T>(root);
    }

    public class TreeIterator<T extends Number> implements Iterator<T> {
        BinarySearchTree<T> copy = new BinarySearchTree<T>();

        /**
         * creates an iterator with a deep copy of the original tree
         * @param root the root node of the original tree
         */
        public TreeIterator(TreeNode<T> root) {
            copy.root = copyTree(root);
        }

        /**
         * checks if there is still an element in th tree copy
         * @return boolean whether there is still one
         */
        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        /**
         * outputs the next resp. the root of the copy and then deletes it from the to be iterated tree
         * @return current root node
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException(); //exception if no follower

            T returner = copy.root.getValue();
            copy.delete(copy.root.getValue());
            return returner;
        }

        /**
         * deep copies the given tree node recursive
         * @param root current to be copied node
         * @return the copied node with all of its children also copied
         */
        private TreeNode<T> copyTree(TreeNode<T> root) {
            if (root == null) {
                return null;
            }

            TreeNode<T> root_copy = new TreeNode<T>(root.getValue());

            root_copy.setLeftChild(copyTree(root.getLeftChild()));
            root_copy.setRightChild(copyTree(root.getRightChild()));

            return root_copy;
        }
    }
}
