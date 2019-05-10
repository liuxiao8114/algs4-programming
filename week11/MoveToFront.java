public class MoveToFront {
  // apply move-to-front encoding, reading from standard input and writing to standard output
  public static void encode() {
    int R = 256,
        lgR = 8;

    String s = BinaryStdIn.readString();
    char[] input = s.toCharArray();
    for(int i = 0; i < input.length(); i++) {
      BinaryStdIn.readChar(input[i])
    }
  }

  // apply move-to-front decoding, reading from standard input and writing to standard output
  public static void decode() {

  }

  // if args[0] is '-', apply move-to-front encoding
  // if args[0] is '+', apply move-to-front decoding
  public static void main(String[] args) {

  }
}
