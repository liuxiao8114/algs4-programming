import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int dequeSize;
	
	private class Node {
		Node next;
		Node prev;
		Item item;
	}
	
	// construct an empty deque
	public Deque() {
		dequeSize = 0;
   }                           
   
   // is the deque empty?
   public boolean isEmpty() {
	   return first == null;
   }                
   
   // return the number of items on the deque
   public int size() {
	   return dequeSize;
   }   
   
   // add the item to the front
   public void addFirst(Item item) {
	   if(item == null) throw new IllegalArgumentException();
	   if(first == null) {
		   first = new Node();
		   first.item = item;
		   last = first;
	   } else {
		   Node oldFirst = first;
		   first = new Node();
		   first.next = oldFirst;
		   first.item = item;
		   first.prev = null;
		   oldFirst.prev = first;
	   }
	   dequeSize++;
   }         
   
   // add the item to the end
   public void addLast(Item item) {
	   if(item == null) throw new IllegalArgumentException();
	   if(last == null) {
		   addFirst(item);
	   } else {
		   Node oldLast = last;
		   last = new Node();
		   last.next = null;
		   last.item = item;
		   last.prev = oldLast;
		   oldLast.next = last;
		   dequeSize++;
	   }
   }   
   
   // remove and return the item from the front
   public Item removeFirst() {
	   if(this.isEmpty()) {
		   throw new NoSuchElementException("cannot find first item because of empty");
	   }
	   Node oldFirst = first;
	   first = first.next;
	   if(first == null) {
		   last = first;
	   } else {
		   first.prev = null;
	   }

	   dequeSize--;
	   return oldFirst.item;
   }
   
   // remove and return the item from the end
   public Item removeLast() {
	   if(this.isEmpty()) {
		   throw new NoSuchElementException("cannot find last item because of empty");
	   }
	   Node oldLast = last;
	   last = last.prev;
	   if(last == null) {
		   first = last;
	   } else {
		   last.next = null;
	   }
	  
	   dequeSize--; 
	   return oldLast.item;
   }
   
   private class DequeIterator implements Iterator<Item>{
	   
	   private Node cur = first;

	   @Override
	   public boolean hasNext() {
		   return cur != null;
	   }
		
	   @Override
	   public Item next() {
		   if(!this.hasNext()) {
			  throw new NoSuchElementException(); 
		   }
		   Node old = cur;
		   cur = cur.next;
		   return old.item;
	   }
	   
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
   }

   // return an iterator over items in order from front to end
   public Iterator<Item> iterator() {
	   return new DequeIterator();
	   
   }
   
   // unit testing (optional)
   public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		int n = 0;
/*
		int k = Integer.parseInt(args[0]);
		while (!StdIn.isEmpty()) {
		    String item = StdIn.readString();
		    queue.enqueue(item);
		    n++;
		}
		assert(k <= n);

		Iterator<Integer> iter = deque.iterator();

		for(int i = 0; iter.hasNext() && (i < k); i++) {
			StdOut.println(iter.next() + " ");
		}	

*/
		 deque.addLast(0);
         StdOut.println(deque.isEmpty());
         deque.addLast(2);
         StdOut.println(deque.removeFirst());
         StdOut.println(deque.isEmpty());

   }
}
