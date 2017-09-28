
public interface Queue<T> {
	public void enqueue(T t);
	public T dequeue();
	public boolean isEmpty();
}
