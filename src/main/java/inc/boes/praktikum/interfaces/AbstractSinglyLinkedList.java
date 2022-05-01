package inc.boes.praktikum.interfaces;

public interface AbstractSinglyLinkedList <T>{
    void add(T Node);                       //adds Node to the end of the list
    void insertafter(T Node,int pointer);   //adds Node after the pointer

    void removeLast();                      //removes last Node
    void removeatPointer(int pointer);      //removes Node at given pointer
    void removeNode (T Node);               //removes first Node after given Node
    void removeNodes (T Node);              //remvoes all Nodes containing the Node

    T getNode(int pointer);                 //gives back Node, sets pointer to current Node
    int findPointerof(T Node);              //returns first Node containing the Node
    int[] findPointersof(T Node);           //returns all Nodes containing the Node

    String toString();                      //format i: getObject(i)\n

}
