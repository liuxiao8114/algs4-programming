public class KMP {
  private final int R;       // the radix
  private int[][] dfa;       // the KMP automoton

  private char[] pattern;    // either the character array for the pattern
  private String pat;        // or the pattern string

  public KMP(String pat) {
    this.pat = pat;
    this.R = 256;

    int m = pat.length();
    dfa[pat.charAt(0)][0] = 1;
    for(int x = 0, j = 1; x < m; j++) {
      for(int c = 0; c < R; c++)
        dfa[c][j] = dfa[c][x];
      dfa[pat.charAt(j)][j] = j + 1;
      x = dfa[pat.charAt(j)][x];
    }
  }

  private int[][] dfa(String txt) {
    int N = txt.length(), M = pattern.length();
    // 1. how to get different char list?
    int[][] dfa = new int[N][M];
    for(int i = 0; i < N; i++) {
      for(int j = 0; ) {

      }
      dfa[txt.charAt(i)]
    }
  }

  public int search(String txt) {
    int m = pat.length();
    int n = text.length();
    int i, j;
    for(i = 0, j = 0; i < n && j < m; i++) {
      j = dfa[txt.charAt(i)][j];
    }
    if(j == m) return i - m;
    return n;
  }
}
