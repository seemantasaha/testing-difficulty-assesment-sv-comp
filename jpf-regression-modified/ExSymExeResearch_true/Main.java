public class Main {

  public static void main(String[] args) {
    test(5,6);
  }

  public static void test(int a, int b) {
    int result = 0;
    System.out.println("Testing ExSymExeResearch");
    if (a >= 0 && a < 100 && b >= 0 && b < 100) {
      int sum = a + b;
      int diff = a - b;
      int temp;

      if (sum > 0)
        temp = a;
      else
        temp = b;
      if (temp < diff) {
        result = temp;
      }
      else {
        result = diff;
      }
    }
    assert false;
  }
}
