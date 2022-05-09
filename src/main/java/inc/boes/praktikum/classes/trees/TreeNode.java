package inc.boes.praktikum.classes.trees;

public class TreeNode<T extends Number> {
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
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
