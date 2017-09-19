import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		
	}   
	
	// is the randomized queue empty?
	public boolean isEmpty() {
		
	}   
	
	
	public int size()                        // return the number of items on the randomized queue
	public void enqueue(Item item)           // add the item
	public Item dequeue()                    // remove and return a random item
	public Item sample()                     // return a random item (but do not remove it)
	public Iterator<Item> iterator()         // return an independent iterator over items in random order
	public static void main(String[] args)   // unit testing (optional)

}
