import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class WordNet {
   private Digraph synsetsG;
   private String[] nouns;
   private ST<String, Bag<Integer>> ids; //inverted index for nouns
   private SAP sap;

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) {
    if(synsets == null || hypernyms == null)
      throw new IllegalArgumentException("null constructor");
      In inSynsets = new In(synsets);
      In inHypernyms = new In(hypernyms);

      String[] lines = inSynsets.readAll().split("\n");
      int length = lines.length;

      this.synsetsG = new Digraph(length);
      this.nouns = new String[length];
      this.ids = new ST<String, Bag<Integer>>();

      for(int i = 0; i < length; i++) {
        this.nouns[i] = lines[i].split(",")[1];
        String[] temp = this.nouns[i].split(" ");

        for(int j = 0; j < temp.length; j++) {
          // key: noun, value: index
          if(this.ids.contains(temp[j])) {
            this.ids.get(temp[j]).add(i);
          } else {
            Bag<Integer> b = new Bag<Integer>();
            b.add(i);
            this.ids.put(temp[j], b);
          }
        }
      }

      lines = inHypernyms.readAll().split("\n");
      length = lines.length;

      for(int i = 0; i < length; i++) {
        String[] temp = lines[i].split(",");
        for(int j = 1; j < temp.length; j++)
          this.synsetsG.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[j]));
      }
      
      DirectedCycle dc = new DirectedCycle(synsetsG);
      if(dc.hasCycle()) throw new IllegalArgumentException("has cycle");
      
      this.sap = new SAP(synsetsG);
   }

   // returns all WordNet nouns
   public Iterable<String> nouns() {
     return ids.keys();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
     if(word == null)
       throw new IllegalArgumentException("invaild args");
     return ids.contains(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB) {
     if(!isNoun(nounA) || !isNoun(nounB))
       throw new IllegalArgumentException("noun is not found in wordnet");
     return sap.length(ids.get(nounA), ids.get(nounB));
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
     if(!isNoun(nounA) || !isNoun(nounB))
       throw new IllegalArgumentException("noun is not found in wordnet");

     return this.nouns[sap.ancestor(ids.get(nounA), ids.get(nounB))];
   }

   // do unit testing of this class
   public static void main(String[] args) {
     WordNet wn = new WordNet(args[0], args[1]);
     System.out.println(wn.synsetsG);
     System.out.println(wn.isNoun("B"));
     System.out.println(wn.isNoun("h"));
     String start = "c";
     String end = "j";
     System.out.println("distance between " + start + " and " + end + ": " + wn.distance(start, end));
   }
}
