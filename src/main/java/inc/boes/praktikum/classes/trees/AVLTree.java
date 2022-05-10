package inc.boes.praktikum.classes.trees;

import inc.boes.praktikum.interfaces.AbstractAVLTree;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AVLTree<T extends Number> implements AbstractAVLTree<T>, Iterable<T>{

    /**
     * root node of the AVLTree
     */
    private TreeNode<T> root;

    /**
     * constructor of AVLTree which sets the root to null
     */
    public AVLTree(){
        root = null;
    }

    /**
     * method to get the root of the tree
     * @return root_node
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * a utility function to right rotate subtree rooted with y
     * @param y node which should be rotated
     * @return rotated nodes
     */
    private @NotNull TreeNode<T> rightRotate(@NotNull TreeNode<T> y) {
        TreeNode<T> x = y.getLeftChild();
        TreeNode<T> tempNodeRightChild = x.getRightChild();

        // Perform rotation
        x.setRightChild(y);
        y.setLeftChild(tempNodeRightChild);

        // Update heights
        y.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);
        x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);

        return x;
    }

    /**
     * a utility function to left rotate subtree rooted with x
     * @param x node which should be rotated
     * @return rotated nodes
     */
    private @NotNull TreeNode<T> leftRotate(@NotNull TreeNode<T> x) {
       TreeNode<T> y = x.getRightChild();
       TreeNode<T> tempNodeLeftChild = y.getLeftChild();

       // Perform rotation
       y.setLeftChild(x);
       x.setRightChild(tempNodeLeftChild);

       // Update heights
       x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);
       x.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);

       return y;
    }

    /**
     * get Balance factor of node
     * @param node where to get the factor
     * @return the balance factor
     */
    private int getBalance(TreeNode<T> node) {
        if(node == null) {
            return 0;
        }
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    /**
     * a utility function to get height of the tree
     * @param node where to get the height
     * @return the actual height
     */
    private int height(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
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
        /* 1. Perform the normal BST rotation */
        if (current == null) {
            return new TreeNode<>(value);
        } else if(value.doubleValue() < current.getValue().doubleValue()){
            current.setLeftChild(insertion(current.getLeftChild(), value));
        } else if(value.doubleValue() > current.getValue().doubleValue()){
            current.setRightChild(insertion(current.getRightChild(), value));
        }

        /* 2. Update height of this ancestor node */
        current.setHeight(Math.max(height(current.getLeftChild()), height(current.getRightChild())) + 1);

        /* 3. balance the tree node*/
        current = balance(current, value);

        return current;
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
    private TreeNode<T> deletion (TreeNode<T> current, T value) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (current == null) {
            return null;
        }

        // If the value to be deleted is smaller than the root's value, then it lies in left subtree
        // If the value to be deleted is greater than the root's value, then it lies in right subtree
        // if value is same as root's value, then this is the node to be deleted
        if (value.doubleValue() < current.getValue().doubleValue()) {
            current.setLeftChild(deletion(current.getLeftChild(), value));
        } else if (value.doubleValue() > current.getValue().doubleValue()) {
            current.setRightChild(deletion(current.getRightChild(), value));
        } else {
            // node with only one child or no child
            if ((current.getLeftChild() == null) || (current.getRightChild() == null)) {
                TreeNode<T> temp = null;
                if (null == current.getLeftChild()) {
                    temp = current.getRightChild();
                } else {
                    temp = current.getLeftChild();
                }

                // No child case
                if (temp == null) {
                    temp = current;
                    current = null;
                } else /* One child case */ {
                    current = temp; //Copy the contents of the non-empty child
                }
            } else {
                // node with two children: Get the inorder successor (smallest in the right subtree)
                TreeNode<T> temp = minValueNode(current.getRightChild());

                // Copy the inorder successor's data to this node
                current.setValue(temp.getValue());

                // Delete the inorder successor
                current.setRightChild(deletion(current.getRightChild(), temp.getValue()));
            }
        }

        // If the tree had only one node then return
        if (current == null) {
            return current;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        current.setHeight(Math.max(height(current.getLeftChild()), height(current.getRightChild()) + 1));

        // STEP 3: BALANCE THE NODE IF NEEDED
        current = balance(current, value);

        return current;
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
        if(current == null) {
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
     * gets the balance factor of the node and if unbalanced executes one of 4 different cases ofr the rotation
     * @param current to be balanced node
     * @param value value to compare with
     * @return balanced node
     */
    private TreeNode<T> balance(TreeNode<T> current, T value) {
        /* Get the balance factor of this ancestor node to check whether this node became unbalanced */
        int balance = getBalance(current);

        // If this node becomes unbalanced, then are 4 cases
        //LeftLeft
        if (balance > 1 && value.doubleValue() < current.getLeftChild().getValue().doubleValue()) {
            return rightRotate(current);
        }

        //RightRight
        if (balance < -1 && value.doubleValue() > current.getRightChild().getValue().doubleValue()) {
            return leftRotate(current);
        }

        //LeftRight
        if (balance > 1 && value.doubleValue() > current.getLeftChild().getValue().doubleValue()) {
            current.setLeftChild(leftRotate(current.getLeftChild()));
            return rightRotate(current);
        }

        //RightLeft
        if (balance < -1 && value.doubleValue() < current.getRightChild().getValue().doubleValue()) {
            current.setRightChild(rightRotate(current.getRightChild()));
            return leftRotate(current);
        }
        /* return the (unchanged) node pointer */
        return current;
    }

    /**
     * Given a non-empty binary search tree, return the node with minimum key value found in that tree.
     * @param node to be looked through node
     * @return node with the smallest value
     */
    private TreeNode<T> minValueNode(TreeNode<T> node) {
        TreeNode<T> current = node;

        while(current.getLeftChild() != null) {
            current = current.getLeftChild();
        }

        return current;
    }

    /**
     * checks whether the tree is empty by looking up if the root has a value
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
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
        if (node != null) {
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
        if (node != null) {
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
        if (node != null) {
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
        AVLTree<T> copy = new AVLTree<T>();

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
