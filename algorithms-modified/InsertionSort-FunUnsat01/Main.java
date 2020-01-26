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
    test(5,6);
  }

  public static void test(int N, int n) {
    if(N<=0)
      return;

    int a[] = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = n;
    }

    sort(a);
    //assert (N < 2 || a[0] < a[1]); // values can now be equal as well
    assert false;
  }
}

