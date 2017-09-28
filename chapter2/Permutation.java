import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	public static void main(String[] args)  {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        int n = 0;
        
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
            n++;
        }
       
        assert(k <= n);
        
        Iterator<String> iter = queue.iterator();
 
        for(int i = 0; iter.hasNext() && (i < k); i++) {
        	StdOut.println(iter.next() + " ");
        }
	}
}
