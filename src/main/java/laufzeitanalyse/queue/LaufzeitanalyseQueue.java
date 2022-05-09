package laufzeitanalyse.queue;

import java.util.LinkedList;

public class LaufzeitanalyseQueue {
    private inc.boes.praktikum.classes.queue.Queue<Integer> myOwnQueue = new inc.boes.praktikum.classes.queue.Queue<>();
    private java.util.Queue<Integer> javaQueue = new LinkedList<>();

    public LaufzeitanalyseQueue() {}

    public double[] addElements(int numberOfElements) {
        myOwnQueue = new inc.boes.praktikum.classes.queue.Queue<>();
        javaQueue = new LinkedList<>();
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnQueue.enqueue((int)(Math.random()*Integer.MAX_VALUE));
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaQueue.add((int)(Math.random()*Integer.MAX_VALUE));
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double)own_time/(double)java_time;
        double[] returner = {own_time, myOwnQueue.size(), java_time, javaQueue.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }
    public double[] removeElements(int numberOfElements) {
        myOwnQueue = new inc.boes.praktikum.classes.queue.Queue<>();
        javaQueue = new LinkedList<>();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnQueue.enqueue((int)(Math.random()*Integer.MAX_VALUE));
        }
        for (int i = 0; i < numberOfElements; i++) {
            javaQueue.add((int)(Math.random()*Integer.MAX_VALUE));
        }
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnQueue.dequeue();
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaQueue.remove();
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double)own_time/(double)java_time;
        double[] returner = {own_time, myOwnQueue.size(), java_time, javaQueue.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }

    public static void main(String[] args) {
        int numberOfRuns = 100;
        int numberOfElements = 1000;
        System.out.println("ENQUEUE");
        for (int j = 10; j <= numberOfElements; j+=10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseQueue analyse = new LaufzeitanalyseQueue();
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
        System.out.println("DEQUEUE");
        for (int j = 10; j <= numberOfElements; j+=10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseQueue analyse = new LaufzeitanalyseQueue();
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
