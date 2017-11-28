import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] items;
	private int n;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		items = (Item[])new Object[2];
		n = 0;
	}   
	
	private class RandomizedArrayIterator implements Iterator<Item> {
		private int index;
		private Item[] randomItems;
		
		public RandomizedArrayIterator() {
			index = 0;
			randomItems = (Item[])new Object[n];
			for(int i = 0; i < n; i++) {
				int r = i + StdRandom.uniform(n - i);
				Item temp = items[i];
				items[i] = items[r];
				items[r] = temp;
				randomItems[i] = items[i];
			}
		}
		
		@Override
		public boolean hasNext() {
			return (index < n && randomItems[index] != null);
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException("no more elements");
			return randomItems[index++];
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	// return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() {
		return new RandomizedArrayIterator();
	}

	// is the randomized queue empty?
	public boolean isEmpty() {
		return items[0] == null;
	}   
	
	// return the number of items on the randomized queue
	public int size() {
		return n;
	}   
	
	// add the item
	public void enqueue(Item item) {
		if(item == null) throw new IllegalArgumentException();
		if(n == items.length) {
			resize(items.length * 2);
		}
		
		items[n++] = item;
	}
	
	private void resize(int newSize) {
		assert newSize >= n;
		Item[] temp = (Item[])new Object[newSize];
		
		for(int i = 0; i < n; i++) {
			temp[i] = items[i];
		}
		
		items = temp;
	}
	
	// remove and return a random item
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException();
		Item i = items[n - 1];
		items[n - 1] = null;
		n--;
		if(n > 0 && n <= items.length / 4) {
			resize(items.length / 2);
		}
		return i;
	}   
	
	// return a random item (but do not remove it)
	public Item sample() {
		if(isEmpty()) throw new NoSuchElementException();
		return items[StdRandom.uniform(n)];
	}                   
	
	// unit testing (optional)
	public static void main(String[] args)  {
        String[] whiteLists = new In("C:\\workspace\\algs4-test-data\\queues\\xiao.txt").readAllStrings();
        
		RandomizedQueue<String> q = new RandomizedQueue<String>();
        
        for(int i = 0; i < whiteLists.length; i++) {
        	q.enqueue(whiteLists[i]);
        }
        
        StdOut.println("lengh1: " + q.size());
        
        Iterator<String> iter1 = q.iterator();
        Iterator<String> iter2 = q.iterator();
        
        while(iter1.hasNext()) {
        	StdOut.print(iter1.next() + " ");
        }
        
        StdOut.println();
        
    	while(iter2.hasNext()) {
    		StdOut.print(iter2.next() + " ");
    	}
        
        /*
        for (String s : q) {
        	StdOut.print(s + " ");
        }
        
        StdOut.println();
        
        q.dequeue();

        StdOut.println("lengh2: " + q.size());
        
        for (String s : q) {
        	StdOut.print(s + " ");
        }
        
        q.enqueue("10");
        StdOut.println();
        StdOut.println("lengh2: " + q.size());
        
        for (String s : q) {
        	StdOut.print(s + " ");
        }
         * */


	}

}
