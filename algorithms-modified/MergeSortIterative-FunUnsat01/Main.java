import java.util.Random;

public class Main {

  public static void main(String[] args) {
    test(5,6);
  }

  public static void test(int N, int n) {
    if(N <= 0)
      return;

    int data[] = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = n;
    }
    iterativeMergesort(data);

    //assert(data[0] < data[1] || N < 2); // data[0] can be equal to data[1]
    assert false;
  }

  /////////////////////////////////////////
  // Iterative mergeSort
  /////////////////////////////////////////

	public static void iterativeMergesort(int[] a) {
    int[] aux = new int[a.length];
		for (int blockSize=1; blockSize<a.length; blockSize*=2)
			for (int start=0; start<a.length; start+=2*blockSize)
				merge(a, aux, start, start+blockSize, start+2*blockSize);
	}

	/////////////////////////////////////////
	// Iterative mergeSort without copy
	/////////////////////////////////////////

  public static void iterativeMergesortWithoutCopy(int[] a) {
    int[] from = a, to = new int[a.length];
    for (int blockSize=1; blockSize<a.length; blockSize*=2) {
      for (int start=0; start<a.length; start+=2*blockSize)
        mergeWithoutCopy(from, to, start, start+blockSize, start+2*blockSize);
      int[] temp = from;
      from = to;
      to = temp;
    }
    if (a != from)
      // copy back
      for (int k = 0; k < a.length; k++)
        a[k] = from[k];
  }

  private static void mergeWithoutCopy(int[] from, int[] to, int lo, int mid, int hi) {
    // DK: cannot just return if mid >= a.length, but must still copy remaining elements!
    // DK: add two tests to first verify "mid" and "hi" are in range
    if (mid > from.length) mid = from.length;
    if (hi > from.length) hi = from.length;
    int i = lo, j = mid;
    for (int k = lo; k < hi; k++) {
      if      (i == mid)          to[k] = from[j++];
      else if (j == hi)           to[k] = from[i++];
      else if (from[j] < from[i]) to[k] = from[j++];
      else                        to[k] = from[i++];
    }
    // DO NOT copy back
    // for (int k = lo; k < hi; k++)
    //   a[k] = aux[k];
  }

  /////////////////////////////////////////
  // Recursive mergeSort, adapted from:
  // Sedgewick and Wayne, Introduction to Programming in Java
  // http://www.cs.princeton.edu/introcs/42sort/MergeSort.java.html
  /////////////////////////////////////////

  private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    // DK: add two tests to first verify "mid" and "hi" are in range
    if (mid >= a.length) return;
    if (hi > a.length) hi = a.length;
    int i = lo, j = mid;
    for (int k = lo; k < hi; k++) {
      if      (i == mid)     aux[k] = a[j++];
      else if (j == hi)      aux[k] = a[i++];
      else if (a[j] < a[i])  aux[k] = a[j++];
      else                   aux[k] = a[i++];
    }
    // copy back
    for (int k = lo; k < hi; k++)
      a[k] = aux[k];
  }

  public static void recursiveMergesort(int[] a, int[] aux, int lo, int hi) {
    // base case
    if (hi - lo <= 1) return;
    // sort each half, recursively
    int mid = lo + (hi - lo) / 2;
    recursiveMergesort(a, aux, lo, mid);
    recursiveMergesort(a, aux, mid, hi);
    // merge back together
    merge(a, aux, lo, mid, hi);
  }

  public static void recursiveMergesort(int[] a) {
    int n = a.length;
    int[] aux = new int[n];
    recursiveMergesort(a, aux, 0, n);
  }

  public static int[] copyArray(int[] a) {
    int[] copy = new int[a.length];
    for (int i=0; i<a.length; i++)
      copy[i] = a[i];
    return copy;
  }

  public static int[] makeRandomArray(int n) {
    int[] a = new int[n];
    for (int i=0; i<a.length; i++)
      a[i] = new Random().nextInt();
    return a;
  }
}

