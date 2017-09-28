import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class ArraysStackOfStrings implements Stack<String>,Iterable<String> {
	private String[] s;
	private int N;
	
	public ArraysStackOfStrings (int capacity) {
		s = new String[capacity];
		N = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return N == 0;
		
	}

	@Override
	public String pop() {
		return s[--N];
	}
	
	@Override
	public void push(String t) {
		s[N++] = t;
	}
	
	private class ReverseArrayIterator implements Iterator<String> {
		private int current = N - 1;

		@Override
		public boolean hasNext() {
			return current >= 0;
		}

		@Override
		public String next() {
			if(!hasNext()) { throw new NoSuchElementException(); }
			return s[current--];
		}
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
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
