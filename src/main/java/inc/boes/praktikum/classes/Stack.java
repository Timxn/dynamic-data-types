package inc.boes.praktikum.*;

public interface Stack<T> implements AbstractStack {
    private ArrayList<T> array;

    public Stack<T>(){
        array = new ArrayList<T>();
    }

    @Override
    public void push(T object) {
        array.add(object);
    } 

    @Override
    public T pop() {
        array.remove(array.getLength());
    }

    @Override
    public T top() {
        return array.get(array.getLength());
    }
}
