import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
  private WordNet wn;

  // constructor takes a WordNet object
  public Outcast(WordNet wordnet) {
    wn = wordnet;
  }

  // given an array of WordNet nouns, return an outcast
  public String outcast(String[] nouns) {
	int max = 0,
		current = 0,
		index = -1;

	for(int i = 0; i < nouns.length; i++) {
		Iterator<String> iter = wn.nouns().iterator();
		while(iter.hasNext()) {
			current += wn.distance(nouns[i], iter.next());
		}

		if(current > max) {
			max = current;
			index = i;
		}
	}
	return nouns[index];
  }

  public static void main(String[] args) {
    WordNet wordnet = new WordNet(args[0], args[1]);
    Outcast outcast = new Outcast(wordnet);
    for (int t = 2; t < args.length; t++) {
        In in = new In(args[t]);
        String[] nouns = in.readAllStrings();
        StdOut.println(args[t] + ": " + outcast.outcast(nouns));
    }
  }
}
