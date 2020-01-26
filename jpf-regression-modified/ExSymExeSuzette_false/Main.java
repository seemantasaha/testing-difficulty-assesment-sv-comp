import java.util.Random;

public class Main {
  public static void test(int x, int y) {

    int v = method_a(x, y);

    if (v > 0) {

      System.out.println("branch taken");

      int tmp = method_b(x); // orig method_b(x)

      if (tmp == x) // added

        System.out.println("inner branch taken"); // added

    } else
      assert false;
  }

  public static int method_a(int x, int y) {

    if (x > 10)

      return x;

    if (y > 10)

      return y;

    return 0;
  }
  public static int method_b(int z) {

    if (z > 10)
      return z++;
    else
      return z--;
  }

  public static void main(String[] args) {

    Random rand = new Random();
    test(rand.nextInt(), rand.nextInt());
  }
}
