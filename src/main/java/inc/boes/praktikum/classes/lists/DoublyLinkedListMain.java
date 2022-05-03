package inc.boes.praktikum.classes.lists;

public class DoublyLinkedListMain {
    private static DoublyLinkedList<Integer> doubleLinkedList;
    public static void main(String[] args) {
        System.out.println("Hello World");
        doubleLinkedList = new DoublyLinkedList<>(42);
        System.out.println(doubleLinkedList.toString());

        doubleLinkedList.add(5);
        doubleLinkedList.add(5);
        doubleLinkedList.add(7);
        doubleLinkedList.add(23);
        doubleLinkedList.add(5);
        doubleLinkedList.add(5);
        doubleLinkedList.add(2);
        doubleLinkedList.add(23);

        System.out.println(doubleLinkedList.toString());

        System.out.println("remove last");
        doubleLinkedList.removeLast();
        System.out.println(doubleLinkedList.toString());

        System.out.println("remove all nodes with 5");
        doubleLinkedList.removeAllOfThisValues(5);
        System.out.println(doubleLinkedList.toString());

        doubleLinkedList.add(5);
        doubleLinkedList.add(5);
        doubleLinkedList.add(2);
        doubleLinkedList.add(23);

        System.out.println(doubleLinkedList.toString());

        System.out.println("insert after every 23 a 42");
        int numberOf23s = doubleLinkedList.getAllPositionsOfValue(23).length;
        System.out.println(numberOf23s);
        for (int i = 0; i < numberOf23s; i++) {
            int[] temps = doubleLinkedList.getAllPositionsOfValue(23);
            doubleLinkedList.insertAfter(42, temps[i]);
        }
        System.out.println(doubleLinkedList.toString());

        System.out.println("The Value of the node at position 5 is " + doubleLinkedList.getValue(5));
    }
}
