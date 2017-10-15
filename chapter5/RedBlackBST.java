private Node rotationLeft(Node h) {
  Node x = h.right;
  h.right = x.left;
  x.left = h;
  x.color = h.color;
  h.color = RED;
  return x;
}

private Node rotaitionRight(Node s) {
  Node h = s.left;
  s.left = h.right;
  h.right = s;
  h.color = s.color;
  s.color = RED;
  return h;
}

public void flip() {
  
}

public Node put(Node ) {

}
