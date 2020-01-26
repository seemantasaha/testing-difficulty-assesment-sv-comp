public class Main {

  private static class List {
    public int x;
    public List next;

    private static final int SENTINEL = Integer.MAX_VALUE;

    private List(int x, List next) {
      this.x = x;
      this.next = next;
    }

    public List() {
      this(SENTINEL, null);
    }

    public void insert(int data) {
      if (data > this.x) {
        next.insert(data);
      } else {
        next = new List(x, next);
        x = data;
      }
    }
  }

  public static void main(String[] args) {
    test(5,6);
  }

  public static void test(int N, int n) {
    if(N <= 1)
      return;

    List list = new List();
    for (int i = 0; i < N; i++){
      list.insert(n);
    }

    for (List l = list; l.next != null; l = l.next){
      //assert (l.x <= l.next.x);
      assert false;
    }
  }
}
