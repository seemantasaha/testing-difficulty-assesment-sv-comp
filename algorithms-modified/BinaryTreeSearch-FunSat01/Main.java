public class Main {

  private static class BinaryTree {
    /**
     * Internal class representing a Node in the tree.
     */
    private static class Node {
      int value;
      Node left;
      Node right;

      Node(int v, Node l, Node r) {
        value = v;
        left = l;
        right = r;
      }
    }

    private Node root = null;

    /**
     * Inserts a value in to the tree.
     */
    public void insert(int v) {

      if (root == null) {
        root = new Node(v, null, null);
        return;
      }

      Node curr = root;
      while (true) {
        if (curr.value < v) {
          if (curr.right != null) {
            curr = curr.right;
          } else {
            curr.right = new Node(v, null, null);
            break;
          }
        } else if (curr.value > v) {
          if (curr.left != null) {
            curr = curr.left;
          } else {
            curr.left = new Node(v, null, null);
            break;
          }
        } else {
          break;
        }
      }
    }

    /**
     * Searches for a value in the tree.
     */
    public boolean search(int v) {
      Node curr = root;
      while (curr != null) {  // N branches
        if (curr.value == v) {  // N-1 branches
          return true;
        } else if (curr.value < v) {  // N-1 branches
          curr = curr.right;
        } else {
          curr = curr.left;
        }
      }
      return false;
    }
  }


  public static void main(String args[]) {
    test(5,6,7);    
  }

  public static void test(int N, int n, int v) {
  	BinaryTree b = new BinaryTree();
    for (int i = 1; i < N; i++){
      if(n >= 0){ // only insert positive numbers
        b.insert(n);
      }
    }

    if(v>=0)
    	return;
    //assert(b.search(v) == false); // didn't put in any negative numbers
    assert false;
  }
}

