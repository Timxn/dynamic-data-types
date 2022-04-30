package inc.boes.praktikum.interfaces;

public interface AbstractSinglyLinkedList <T>{
    void add(T Node);                       //adds Node to the end of the list
    void insertafter(T Node,int pointer);   //adds Node after the pointer

    void removeLast();
    void removeatPointer(int pointer);
    void removeNode (T Node);
    void remodeNodes (T Node);

    T getNode(int pointer);
    int findPointerof(T Node);
    int[] findPointersof(T Node);

    String toString();

}
