package laufzeitanalyse;

import java.util.Stack;

public class LaufzeitanalyseStack {
    private inc.boes.praktikum.classes.stack.Stack<Integer> myOwnStack = new inc.boes.praktikum.classes.stack.Stack<>();
    private java.util.Stack<Integer> javaStack = new Stack<>();

    public LaufzeitanalyseStack() {}

    public double[] addElements(int numberOfElements) {
        myOwnStack = new inc.boes.praktikum.classes.stack.Stack<>();
        javaStack = new Stack<>();
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnStack.push((int)(Math.random()*Integer.MAX_VALUE));
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaStack.push((int)(Math.random()*Integer.MAX_VALUE));
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double)own_time/(double)java_time;
        double[] returner = {own_time, myOwnStack.getSize(), java_time, javaStack.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }
    public double[] removeElements(int numberOfElements) {
        myOwnStack = new inc.boes.praktikum.classes.stack.Stack<>();
        javaStack = new Stack<>();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnStack.push((int)(Math.random()*Integer.MAX_VALUE));
        }
        for (int i = 0; i < numberOfElements; i++) {
            javaStack.push((int)(Math.random()*Integer.MAX_VALUE));
        }
        long own_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myOwnStack.pop();
        }
        own_time = System.nanoTime() - own_time;
        long java_time = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            javaStack.pop();
        }
        java_time = System.nanoTime() - java_time;
        double timesLonger = (double)own_time/(double)java_time;
        double[] returner = {own_time, myOwnStack.getSize(), java_time, javaStack.size(), timesLonger};
        return returner;
//        return "My own implementation takes " + own_time + " nanoseconds and the java LinkedList takes " + java_time + " nanoseconds, which means my implementation needs " + timesLonger + " times as long";
    }

    public static void main(String[] args) {
        int numberOfRuns = 100;
        int numberOfElements = 1000;
        System.out.println("Push");
        for (int j = 10; j <= numberOfElements; j+=10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseStack analyse = new LaufzeitanalyseStack();
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
        System.out.println("Pop");
        for (int j = 10; j <= numberOfElements; j+=10) {
            double[][] array = new double[numberOfRuns][];
            for (int i = 0; i < numberOfRuns; i++) {
                LaufzeitanalyseStack analyse = new LaufzeitanalyseStack();
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
