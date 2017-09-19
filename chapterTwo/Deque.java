import java.util.Iterator;
import java.util.NoSuchElementException;

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
	   if(last == null) {
		   addFirst(item);
	   } else {
		   Node oldLast = last;
		   last = new Node();
		   last.next = null;
		   last.item = item;
		   last.prev = oldLast;
	   }
	   dequeSize++;
   }   
   
   // remove and return the item from the front
   public Item removeFirst() {
	   if(this.isEmpty()) {
		   throw new NoSuchElementException("cannot find first item because of empty");
	   }
	   Node oldFirst = first;
	   first = first.next;
	   first.prev = null;
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
	   last.next = null;
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
   }

   // return an iterator over items in order from front to end
   public Iterator<Item> iterator() {
	   return new DequeIterator();
	   
   }
   // unit testing (optional)
   public static void main(String[] args) {
	   
   }
}