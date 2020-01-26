public class Main {

  public static void main(String[] args) {
    test(3,5);
  }

  /*
   * test IADD & IFLT bytecodes (Note: javac compiles ">=" to IFLT)
   */
  public static void test(int x, int z) {
    System.out.println("Testing ExSymExe4");
    int y = 3;
    x = z + y;
    if (z >= 0)
      System.out.println("branch FOO1");
    else {
      System.out.println("branch FOO2");
      assert false;
    }
    if (x >= 0)
      System.out.println("branch BOO1");
    else
      System.out.println("branch BOO2");
  }
}
