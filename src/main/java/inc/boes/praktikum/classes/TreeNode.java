package inc.boes.praktikum.classes;

public class TreeNode<T extends Number> {
    private T root;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T pRoot){
        this.root = pRoot;
    }

    public T getRoot(){
        return root;
    }

    public void setRoot(T pRoot){
        this.root = pRoot;
    }

    public TreeNode<T> getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> pLeft){
        this.leftChild = pLeft;
    }

    public TreeNode<T> getRightChild(){
        return rightChild;
    }

    public void setRightChild(TreeNode<T> pRight){
        this.rightChild = pRight;
    }
}
