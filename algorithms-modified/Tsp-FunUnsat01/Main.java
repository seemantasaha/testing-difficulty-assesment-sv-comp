public class Main {

  private static class TspSolver {
    private final int N;
    private int D[][];
    private boolean visited[];
    private int best;

    public int nCalls;

    public TspSolver(int N, int D[][]) {
      this.N = N;
      this.D = D;
      this.visited = new boolean[N];
      this.nCalls = 0;
    }

    public int solve() {
      best = Integer.MAX_VALUE;

      for (int i = 0; i < N; i++)
        visited[i] = false;

      visited[0] = true;
      search(0, 0, N-1);

      return best;
    }

    private int bound(int src, int length, int nLeft) {
      return length;
    }

    private void search(int src, int length, int nLeft) {
      nCalls++;

      if (nLeft == 0) {
        if (length + D[src][0] < best)
          best = length + D[src][0];
        return;
      }

      if (bound(src, length, nLeft) >= best)
        return;

      for (int i = 0; i < N; i++) {
        if (visited[i]) continue;

        visited[i] = true;
        search(i, length + D[src][i], nLeft - 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String args[]) {
    test(5,6);
  }

  public static void test(int N, int val) {
    if(N<=0)
      return;

    int D[][] = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int next = val;
        if(next < 0)
          return;
        D[i][j] = next;
      }
    }

    TspSolver tspSolver = new TspSolver(N, D);
    int sln = tspSolver.solve();
    //assert ( sln == 42 );
    assert false;
  }
}
