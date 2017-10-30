import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet {
   private Digraph synsetsG;
   private Digraph hypernymsG;

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) {
     In inSynsets = new In(synsets);
     In inHypernyms = new In(hypernyms);

     String[] lines = inSynsets.readAll().split("\r\n");
     int length = lines.length;
     String[] ids = new String[length];

     Bag<String> nouns = new Bag<String>();
     String[] temp = new String[3];
     for(int i = 0; i < length; i++) {
       temp = lines[i].split(",");
       ids[i] = Integer.parseInt(temp[0]);
       
     }


     this.synsetsG = new Digraph(inSynsets);
     this.hypernymsG = new Digraph(inHypernyms);
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
     System.out.println(wn.hypernymsG);
   }
}
