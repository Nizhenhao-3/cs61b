package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T>{
    public int capacity();

    public int fillCount();

    public void enqueue(T x);

    public T dequeue();

    public T peek();

    default public boolean isEmpty(){
        int size=fillCount();
        return size==0;
    }

    default boolean isFUll(){
        int size=fillCount();
        return size==capacity();
    }
}
