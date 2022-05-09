package inc.boes.praktikum.classes.trees;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Number> implements AbstractBinarySearchTree<T>, Iterable<T>{

    private TreeNode<T> root;
    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        root = insertion(root, value);
    }

    /**
     * was die funktion macht
     * @param current
     * @param value
     * @return
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

    @Override
    public void delete(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        root = deletion(root, value);
    }

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

    private T findSmallestValue (@NotNull TreeNode<T> root) {
        return existsNode(root.getLeftChild()) ? root.getValue() : findSmallestValue(root.getLeftChild());
    }

    @Override
    public boolean search(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return searching(root, value);
    }

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

    private boolean existsNode(TreeNode<T> value) {
        return value == null;
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }
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

    private String traverseInOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = traverseInOrder(node.getLeftChild(), out);
            out = out + " " + node.getValue().doubleValue();
            out = traverseInOrder(node.getRightChild(), out);
        }
        return out;
    }

    private String traversePreOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = out + " " + node.getValue().doubleValue();
            out = traversePreOrder(node.getLeftChild(), out);
            out = traversePreOrder(node.getRightChild(), out);
        }
        return out;
    }

    private String traversePostOrder(TreeNode<T> node, String out) {
        if (!existsNode(node)) {
            out = traversePostOrder(node.getLeftChild(), out);
            out = traversePostOrder(node.getRightChild(), out);
            out = out + " " + node.getValue().doubleValue();
        }
        return out;
    }

    @NotNull
    @Override
    public TreeIterator<T> iterator() {
        return new TreeIterator<T>(root);
    }

    public class TreeIterator<T extends Number> implements Iterator<T> {
        BinarySearchTree<T> copy = new BinarySearchTree<T>();
        public TreeIterator(TreeNode<T> root) {
            copy.root = copyTree(root);
        }

        @Override
        public boolean hasNext() {
            return copy.root != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException(); //exception if no follower

            T returner = copy.root.getValue();
            copy.delete(copy.root.getValue());
            return returner;
        }

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
