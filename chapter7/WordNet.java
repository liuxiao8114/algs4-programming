import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet {
   private Digraph synsetsG;
   private Bag<String>[] nouns;

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) {
      In inSynsets = new In(synsets);
      In inHypernyms = new In(hypernyms);

      String[] lines = inSynsets.readAll().split("\r\n");
      int length = lines.length;

      this.synsetsG = new Digraph(length);
      this.nouns = new Bag<String>[length];

      for(int i = 0; i < length; i++) {
        String[] temp = lines[i].split(",")[1].split(" ");
        for(int j = 0; j < temp.length; j++)
          nouns[i].add(temp[j]);
      }

      lines = inHypernyms.readAll().split("\r\n");
      length = lines.length;

      for(int i = 0; i < length; i++) {
        int[] temp = (int[])lines[i].split(",");
        for(int j = 1; j < temp.length; j++)
          this.synsetsG.addEdge(temp[0], temp[j]);
      }
   }

   // returns all WordNet nouns
   public Iterable<String> nouns() {
	   return null;
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
	   return false;
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB) {
	   return 0;
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
	   return null;
   }

   // do unit testing of this class
   public static void main(String[] args) {
     WordNet wn = new WordNet(args[0], args[1]);
     System.out.println(wn.synsetsG);
   }

}
