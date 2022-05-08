package inc.boes.praktikum.classes;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<T extends Number> implements AbstractBinarySearchTree<T>{

    private TreeNode<T> root;
    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T value) {
        root = insertion(root, value);
    }

    private TreeNode<T> insertion(TreeNode<T> current, T value) {
        if(current == null) {
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

    private TreeNode<T> deletion (TreeNode<T> current, T value) {
        if (current == null){
            return null;
        }
        if (value.doubleValue() == current.getValue().doubleValue()) {
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                return null;
            } else if (current.getRightChild() == null) {
                return current.getRightChild();
            } else if (current.getLeftChild() == null) {
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

    private T findSmallestValue (TreeNode<T> root) {
        return root.getLeftChild() == null ? root.getValue() : findSmallestValue(root.getLeftChild());
    }

    @Override
    public boolean search(T value) {
        return searching(root, value);
    }

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

    @Override
    public boolean isEmpty(TreeNode<T> value) {
        return value == null;
    }

    @Override
    public String toString(Traversal traversal) {
        return null;
    }

    public void toStrings(TreeNode<T> pNode){
        if(!isEmpty(pNode.getLeftChild())) {
            toStrings(pNode.getLeftChild());
        } else if(!isEmpty(pNode)) {
            System.out.println(pNode.getValue().doubleValue());
        } else if(!isEmpty(pNode.getRightChild())){
            toStrings(pNode.getRightChild());
        }
    }

    /*public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(1);
        bst.toStrings(root);
    }*/
}
