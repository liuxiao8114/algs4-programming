import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T>,Stack<T> {

	private Node first;
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T t = current.item;
			current = current.next;
			return t;
		}
		
	}
	
	private class Node {
		Node next;
		T item;
		
		public Node(Node n, T i) {
			this.next = n;
			this.item = i;
		}
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public T pop() {
		T t = first.item;
		first = first.next;
		return t;
	}

	@Override
	public void push(T t) {
		Node oldfirst = first;
		first = new Node(oldfirst, t);
	}
	
}
