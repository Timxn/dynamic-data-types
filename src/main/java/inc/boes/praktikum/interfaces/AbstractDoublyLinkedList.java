package inc.boes.praktikum.interfaces;

public interface AbstractDoublyLinkedList <T extends Comparable>{
    void add(T Node);
    void insertAfter (T Node, int index);

    void removeLast();                      //Last Node deleted
    void removeNode (int index);             //removes Node at given pointer
    void removeValue (T Node);               //removes first Node after containing given Node
    void removeAllOfThisValues (T Node);              //remvoes all Nodes containing the Node

    T getValue(int pointernext);             //gives back Node, sets pointer to current Node
    int getPositionOfValue(T Node);              //returns first Node containing the Node
    int[] getAllPositionsOfValue(T Node);           //returns all Nodes containing the Node




}
