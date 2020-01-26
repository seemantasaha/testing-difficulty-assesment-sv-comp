import rbtree.RedBlackTree;
import rbtree.RedBlackTreeNode;

public class Main {
  public static void main(String[] args) {
    test(5);
  }

  public static void test(int N) {
    if(N <= 0)
      return;

    RedBlackTree tree = new RedBlackTree();

    for (int i = 0; i < N; i++)
      tree.treeInsert(new RedBlackTreeNode(i));

    int data = -1;
    RedBlackTreeNode node = tree.treeSearch(tree.root(), data);
    //assert (node != null); // "-1" was not inserted
    assert false;
  }
}

