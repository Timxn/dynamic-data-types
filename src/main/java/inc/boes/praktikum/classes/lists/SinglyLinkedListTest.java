package inc.boes.praktikum.classes.lists;

public class SinglyLinkedListTest {
    static SingleLinkedList<Integer> linkedList;
    public static void main(String[] args) {
        System.out.println("Hallo");
        System.out.println("SingleLinkedList");
        linkedList = new SingleLinkedList<>(42);

        linkedList.add(24);
        System.out.println(linkedList.toString());

        linkedList.insertafter(44, 0);
        System.out.println(linkedList.toString());

        System.out.println("Hello");

    }
}
