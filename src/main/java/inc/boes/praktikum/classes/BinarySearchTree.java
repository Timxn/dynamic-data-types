package inc.boes.praktikum.classes;
import inc.boes.praktikum.interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<T extends Number> implements AbstractBinarySearchTree<T>{

    private TreeNode<T> root;
    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T value) {
        root = insertion(root);
    }

    private TreeNode<T> insertion(TreeNode<T> pNode) {
        if (isEmpty(pNode)) {
            return pNode;
        } else if(pNode.getValue().doubleValue() >= pNode.getValue().doubleValue()) {
            pNode.setLeftChild(insertion(pNode.getLeftChild()));
            return pNode.getLeftChild();
        } else {
            pNode.setRightChild(insertion(pNode.getRightChild()));
            return pNode.getRightChild();
        }
    }

    @Override
    public void delete(T value) {

    }

    @Override
    public boolean search(T value) {
        return false;
    }

    @Override
    public boolean isEmpty(TreeNode<T> pNode) {
        return pNode == null;
    }

    @Override
    public String toString(String traversal) {
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
