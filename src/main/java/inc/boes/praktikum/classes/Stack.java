package inc.boes.praktikum.classes;

import inc.boes.praktikum.interfaces.AbstractStack;

public class Stack<T> implements AbstractStack<T> {
    private int size;
    private Stack_Node root;

    /*  Build a Stack with one Element with the sepcified content   */

    public Stack(T content) {
        this.size = 1;
        this.root = new Stack_Node<>(content);
    }

    /*  Build empty Stack   */

    public Stack() {
        this.size = 0;
        this.root = null;
    }


    /*  add new content to stack    */

    public void push(T content) {
        Stack_Node newNode = new Stack_Node(content);
        newNode.setNext(root);
        root = newNode;
        size++;
    } 


    /*  remove last inserted element and return it    */
    /*  if stack is empty return null  */

    public T pop() {
        if (root != null) {
            T temp = (T) root.getContent();
            if (size > 1) {
                root = root.getNext();
            } else {
                root = null;
            }
            size--;
            return temp;
        } else {
            return null;
        }
    }


    /*  return last inserted element    */
    /*  if stack is empty return null  */

    public T top() {
        if (root != null) {
            return (T) root.getContent();
        } else {
            return null;
        }
    }

    /*  possible optimisation with StringBuilder if needed  */

    @Override
    public String toString() {
        if (root == null) {
            return "Stack is empty";
        } if (size == 1) {
            return "[0] contains " + root.getContent();
        }
        Stack_Node tempNode = root;
        String output = "";
        int counter = 0;
        while (counter < size-1) {          // -1 needed as in code an Stack with 1 element has a size of 1, while beeing represented in Output as position 0
            output = output + "[" + counter + "] contains " + tempNode.getContent() + " | " ;
            tempNode = tempNode.getNext();
            counter++;
        }
        output = output + "[" + counter + "] contains " + tempNode.getContent();
        return output;
    }
}
