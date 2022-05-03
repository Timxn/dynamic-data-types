package inc.boes.praktikum.classes.stack;

public class StackMain {
    private static Stack<Integer> example_stack = new Stack<>();
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Empty Stack: " + example_stack.toString());
        example_stack.push(42);
        System.out.println("Stack with one Element added: " + example_stack.toString());
        for (int i = 0; i < 14; i++) {
            example_stack.push((int)Math.random()*100);
        }
        System.out.println("Stack with 15 Elements: " + example_stack.toString());
        for (int i = 0; i < 5; i++) {
            example_stack.pop();
        }
        System.out.println("Stack with 5 Elements poped (hihi): " + example_stack.toString());
    }

}
