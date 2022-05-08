package inc.boes.praktikum.classes;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BinarySearchTree<T extends Number> implements AbstractBinarySearchTree<T>{

    private TreeNode<T> root;
    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T value) {
        root = insertion(root, value);
    }

    private @NotNull TreeNode<T> insertion(TreeNode<T> current, T value) {
        if(isEmpty(current)) {
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
        root = deletion(root, value);
    }

    private @Nullable TreeNode<T> deletion (TreeNode<T> current, T value) {
        if (isEmpty(current)){
            return null;
        }
        if (value.doubleValue() == current.getValue().doubleValue()) {
            if (isEmpty(current.getLeftChild()) && isEmpty(current.getRightChild())) {
                return null;
            } else if (isEmpty(current.getRightChild())) {
                return current.getRightChild();
            } else if (isEmpty(current.getLeftChild())) {
                return current.getLeftChild();
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
        return isEmpty(root.getLeftChild()) ? root.getValue() : findSmallestValue(root.getLeftChild());
    }

    @Override
    public boolean search(T value) {
        return searching(root, value);
    }

    private boolean searching(TreeNode<T> current, T value){
        if(isEmpty(current)) {
            return false;
        }
        if(value.doubleValue() == current.getValue().doubleValue()) {
            return true;
        }
        return value.doubleValue() < current.getValue().doubleValue()
                ? searching(current.getLeftChild(), value)
                : searching(current.getRightChild(), value);
    }

    @Override
    public boolean isEmpty(TreeNode<T> value) {
        return value == null;
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
        return null; //if wrong traversal
    }

    private String traverseInOrder(TreeNode<T> node, String out) {
        if (!isEmpty(node)) {
            out = traverseInOrder(node.getLeftChild(), out);
            out = out + " " + node.getValue().doubleValue();
            out = traverseInOrder(node.getRightChild(), out);
        }
        return out;
    }

    private String traversePreOrder(TreeNode<T> node, String out) {
        if (!isEmpty(node)) {
            out = out + " " + node.getValue().doubleValue();
            out = traversePreOrder(node.getLeftChild(), out);
            out = traversePreOrder(node.getRightChild(), out);
        }
        return out;
    }

    private String traversePostOrder(TreeNode<T> node, String out) {
        if (!isEmpty(node)) {
            out = traversePostOrder(node.getLeftChild(), out);
            out = traversePostOrder(node.getRightChild(), out);
            out = out + " " + node.getValue().doubleValue();
        }
        return out;
    }
}
