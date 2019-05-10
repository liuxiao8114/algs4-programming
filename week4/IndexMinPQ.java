public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;      // keys[i] = priority of i


    public IndexMinPQ(int maxN) {
    	this.maxN = maxN;
    	n = 0;
    	keys = new Key[maxN + 1]; // why this should be keys = (Key[])new Comparable[maxN + 1]
    	pq = new int[maxN + 1];
    	for(int i = 0; i <= maxN; i++) {
    		qp[i] = -1;
    	}
    }

    private boolean greater(int i, int j) {
    	return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
    	int temp = pq[i];
    	pq[i] = pq[j];
    	pq[j] = temp;
    	qp[pq[i]] = i;
    	qp[pq[j]] = j;
    }

    private void swim(int k) {
    	if(k > 1 && greater(k / 2, k)) {
  			exch(k / 2, k);
  			swim(k / 2);
    	}
    }

    private void sink(int k) {
    	int i = 2 * k;
    	if(i <= n && greater(i, i + 1)) i++;
    	if(greater(k, i)) {
    		exch(i, k);
    		sink(i);
    	}
    }

    private void validate(int i) {
    	if(i < 0 || i >= this.maxN) return throw new IllegalArgumentException();
    }

    public boolean isEmpty() {
    	return n == 0;
    }

    public boolean contains(int i) {
    	validate(i);
    	return qp[i] != -1;
    }

    public int size() {
    	return this.n;
    }

    public void insert(int i, Key key) {
    	validate(i);
    	n++;
    	qp[i] = n;
    	pq[n] = i;
    	keys[i] = key;
    	swim(n);
    }

    public int delMin() {

    }

    public void delete(int i) {
  		validate(i);
  		int index = qp[i];
  		exch(index, n--);
  		swim(index);
      sink(index);
  		keys[i] = null;
  		qp[i] = -1;
    }

    public void decreaseKey(int i, Key key) {

    }
}
