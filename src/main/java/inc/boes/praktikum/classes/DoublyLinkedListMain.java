package inc.boes.praktikum.classes;

public class DoublyLinkedListMain {
    private static DoublyLinkedList<Integer> doubleLinkedList;
    public static void main(String[] args) {
        System.out.println("Hello World");
        doubleLinkedList = new DoublyLinkedList<>(42);
        System.out.println(doubleLinkedList.toString());
        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add((int) (Math.random() * 10));
        }
        System.out.println(doubleLinkedList.toString());

    }
}
