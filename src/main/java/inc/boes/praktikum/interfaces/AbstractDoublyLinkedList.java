package inc.boes.praktikum.interfaces;

public interface AbstractDoublyLinkedList <T>{
    void add(T Node);
    void insertafter (T Node, int pointernext, int pointerprevious);
    void insertatfront (T Node, int pointerprevious);
    void insertbefore (T Node, int pointerprevious);

    void removeLast();  //Last Node deleted
    void removeNode (int pointerprevious, int pointernext);
    void removeatPointer(int pointernext);      //removes Node at given pointer
    void removeNode (T Node);               //removes first Node after containing given Node
    void removeNodes (T Node);              //remvoes all Nodes containing the Node

    T getNode(int pointernext);             //gives back Node, sets pointer to current Node
    int findPointerof(T Node);              //returns first Node containing the Node
    int[] findPointersof(T Node);           //returns all Nodes containing the Node




}
