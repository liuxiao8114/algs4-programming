import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class ResizingArraysStack<T> implements Stack<T>, Iterable<T> {
	private T[] a;
	private int n;
	
	public ResizingArraysStack() {
		a = (T[]) new Object[2];
		n = 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ReverseArraysStackIterator();
	}
	
	private class ReverseArraysStackIterator implements Iterator<T> {
		private int current = n;
		
		@Override
		public boolean hasNext() {
			return current >= 0;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			return a[current--];
		}
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public T pop() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		T t = a[n - 1];
		a[n - 1] = null;
		n--;
		
		if(n > 0 && n < a.length / 4) resize(a.length/2);
		return t;
	}

	@Override
	public void push(T t) {
		if(n == a.length) resize(2 * a.length);
		a[n++] = t;
	}
	
	private void resize(int capacity) {
		if(capacity < n) {
			throw new NoSuchElementException("cannot create an array less than n");
		}
		
		T[] t = (T[])new Object[capacity];
		for(int i = 0; i < n; i++) {
			t[i] = a[i];
		}
		a = t;
	}
	
	public static void main(String[] args) {
        String[] whiteLists = new In("c:\\workspace\\algs4-test-data\\tobe.txt").readAllStrings();
        
        ArraysStackOfStrings stack = new ArraysStackOfStrings(whiteLists.length);
        
        for(int i = 0; i < whiteLists.length; i++) {
        	 String item = whiteLists[i];
             if (!item.equals("-")) stack.push(item); 
             else if (stack.isEmpty())  StdOut.println("BAD INPUT"); 
             else                       StdOut.print(stack.pop() + " ");
        }
        
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
	}
}
