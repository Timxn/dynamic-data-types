package inc.boes.praktikum.*;

public interface Stack<T> implements AbstractStack {
    private ArrayList<T> array;

    public Stack<T>(){
        array = new ArrayList<T>();
    }


    /*  add an object to stack by appending it to the ArrayList */
    
    @Override
    public void push(T object) {
        array.add(object);
    } 


    /*  remove last inserted element and return it    */
    
    @Override
    public T pop() {
        if (array.getLength() > 0) {
            T temp = array.get(array.getLength());
            array.remove(array.getLength());
            return temp;
        }
        return null;
    }


    /*  return last inserted element    */
    
    @Override
    public T top() {
        if (array.getLength() > 0) {
            return array.get(array.getLength());
        }
        return null;
    }
}
