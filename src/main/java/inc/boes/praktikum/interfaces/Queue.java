package inc.boes.praktikum.interfaces;

public interface Queue <T>{
    void addLast (T Node);
    void removeFirst (T Node);
    void remove (T Node, int pointer);          //removes first occurrence of Node

}
