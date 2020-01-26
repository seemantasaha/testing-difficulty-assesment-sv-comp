import rbtree.RedBlackTree;
import rbtree.RedBlackTreeNode;

public class Main {
  public static void main(String[] args) {
    test(5,3);
  }

  public static void test(int N, int n) {
    if(N<=0)
      return;

    RedBlackTree tree = new RedBlackTree();

    for (int i = 0; i < N; i++)
      tree.treeInsert(new RedBlackTreeNode(i));

    int data = n;
    if(data < 0 || data >= N)
      return;
    RedBlackTreeNode node = tree.treeSearch(tree.root(), data);
    //assert (node != null);
    System.out.println("here i am");
    assert false;
  }
}

