
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
   }   
   
   // remove and return the item from the front
   public Item removeFirst() {
	   if
   }
   // remove and return the item from the end
   public Item removeLast() {
	   
   }     

   // return an iterator over items in order from front to end
   public Iterator<Item> iterator() {
	   
	   
   }
   // unit testing (optional)
   public static void main(String[] args) {
	   
   }
}