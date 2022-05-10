package laufzeitanalyse;

import java.util.LinkedList;

public class LaufzeitanalyseSinglyLinkedList {
    private inc.boes.praktikum.classes.lists.SingleLinkedList<Integer> myLinkedList = new inc.boes.praktikum.classes.lists.SingleLinkedList<>();
    private java.util.LinkedList<Integer> javaLinkedList = new LinkedList<>();

    public LaufzeitanalyseSinglyLinkedList() {
    }

    public double[] addElements(int numberOfElements) {
        myLinkedList = new inc.boes.praktikum.classes.lists.SingleLinkedList<>();
        javaLinkedList = new LinkedList<>();
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myLinkedList.add((int) (Math.random() * Integer.MAX_VALUE));
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaLinkedList.add((int) (Math.random() * Integer.MAX_VALUE));
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double) own_time / (double) java_time;
        double[] returner = {own_time, myLinkedList.getSize(), java_time, javaLinkedList.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }

    public double[] removeElements(int numberOfElements) {
        myLinkedList = new inc.boes.praktikum.classes.lists.SingleLinkedList<>();
        javaLinkedList = new LinkedList<>();
        for (int i = 0; i < numberOfElements; i++) {
            myLinkedList.add((int) (Math.random() * Integer.MAX_VALUE));
        }
        for (int i = 0; i < numberOfElements; i++) {
            javaLinkedList.add((int) (Math.random() * Integer.MAX_VALUE));
        }
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myLinkedList.removeLast();
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaLinkedList.clear();
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double) own_time / (double) java_time;
        double[] returner = {own_time, myLinkedList.getSize(), java_time, javaLinkedList.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }

    public static void main(String[] args) {
        int numberOfRuns = 100;
        int numberOfElements = 1000;
        System.out.println("ADD ELEMENTS");
        for (int j = 10; j <= numberOfElements; j += 10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseSinglyLinkedList analyse = new LaufzeitanalyseSinglyLinkedList();
                double[] temp = (analyse.addElements(j));
                array[i] = temp;
            }
            long ownDurchschnitt = 0;
            long javaDurchschnitt = 0;
            for (int i = 0; i < array.length; i++) {
                ownDurchschnitt += array[i][0];
                javaDurchschnitt += array[i][2];
            }
            ownDurchschnitt /= array.length;
            javaDurchschnitt /= array.length;

            System.out.println("Eigenimplementierung: " + ownDurchschnitt + ", Javaimplementierung: " + javaDurchschnitt + ", mit " + j + " Elementen");
        }
        System.out.println("REMOVE ALL ELEMENTS");
        for (int j = 10; j <= numberOfElements; j += 10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseSinglyLinkedList analyse = new LaufzeitanalyseSinglyLinkedList();
                double[] temp = (analyse.removeElements(j));
                array[i] = temp;
            }
            long ownDurchschnitt = 0;
            long javaDurchschnitt = 0;
            for (int i = 0; i < array.length; i++) {
                ownDurchschnitt += array[i][0];
                javaDurchschnitt += array[i][2];
            }
            ownDurchschnitt /= array.length;
            javaDurchschnitt /= array.length;

            System.out.println("Eigenimplementierung: " + ownDurchschnitt + ", Javaimplementierung: " + javaDurchschnitt + ", mit " + j + " Elementen");
        }

    }
}

