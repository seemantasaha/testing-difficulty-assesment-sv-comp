public class Main {

  public static void sort(int[] a) {
    final int N = a.length;
    for (int i = 1; i < N; i++) {  // N branches
      int j = i - 1;
      int x = a[i];
      // First branch (j >= 0):  2 + 3 + ... + N = N(N+1)/2 - 1 branches
      // Second branch (a[j] > x):  1 + 2 + ... + N-1 = (N-1)N/2 branches
      while ((j >= 0) && (a[j] > x)) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = x;
    }
  }

  public static void main(String[] args) {
    test(5,6,7);
  }

  public static void test(int N, int i1, int i2) {
    if(N<=0)
      return;

    int a[] = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = N-i;
    }

    sort(a);
    
    if(0 > i1 || i2 >= N)
      return;
    if(i1 >= i2)
      return;
    //assert (a[i1] <= a[i2]);
    assert false;
  }
}

