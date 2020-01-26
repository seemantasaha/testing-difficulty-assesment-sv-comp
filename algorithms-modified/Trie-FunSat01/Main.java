import java.util.Queue;

public class Main {
  private static final int R = 256;        // extended ASCII


  private Node root;      // root of trie
  private int N = 0;          // number of keys in trie

  // R-way trie node
  private static class Node {
    private int val = -1;
    private Node[] next = new Node[R];
  }

  private static class CharArray {
    private int length = 0;
    public char[] array;
    private static final int DEFAULT_LENGTH = 42;

    public CharArray() {
      this(DEFAULT_LENGTH);
    }

    public CharArray(int length) {
      this.length = length;
      array = new char[length];
    }

    public int length() { return length; }

    public void set(int i, char c) {
      if (i < length)
        array[i] = c;
      else throw new ArrayIndexOutOfBoundsException("Error while setting char!");
    }
    public char get(int i) {
      if (i < length)
        return array[i];
      else throw new ArrayIndexOutOfBoundsException("Error while getting char!");
    }

    public CharArray substring(int start, int end) {
      int subLength = end-start;
      CharArray substr = new CharArray(subLength);
      for(int i = 0; i < subLength; i++)
        substr.set(i, this.get(i));
      return substr;
    }
  }

  /**
   * Initializes an empty string symbol table.
   */
  public Main() {}

  /**
   * Returns the value associated with the given key.
   * @param key the key
   * @return the value associated with the given key if the key is in the symbol table
   *     and <tt>null</tt> if the key is not in the symbol table
   * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
   */
  public int get(CharArray key) {
    Node x = get2(root, key, 0);
    if (x == null) return -1;
    return  x.val;
  }

  /**
   * Does this symbol table contain the given key?
   * @param key the key
   * @return <tt>true</tt> if this symbol table contains <tt>key</tt> and
   *     <tt>false</tt> otherwise
   * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
   */
  public boolean contains(CharArray key) {
    return get(key) != -1;
  }

  private Node get2(Node x, CharArray key, int d) {
    if (x == null) return null;
    if (d == key.length()) return x;
    char c = key.get(d);
    return get2(x.next[c], key, d+1);
  }

  /**
   * Inserts the key-value pair into the symbol table, overwriting the old value
   * with the new value if the key is already in the symbol table.
   * If the value is <tt>null</tt>, this effectively deletes the key from the symbol table.
   * @param key the key
   * @param val the value
   * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
   */
  public void put(CharArray key, int val) {
    if (val == -1) delete(key);
    else root = put2(root, key, val, 0);
  }

  private Node put2(Node x, CharArray key, int val, int d) {
    if (x == null) x = new Node();
    if (d == key.length()) {
      if (x.val == -1) N++;
      x.val = val;
      return x;
    }

    char c = key.get(d);
    x.next[c] = put2(x.next[c], key, val, d+1);
    return x;
  }

  /**
   * Returns the number of key-value pairs in this symbol table.
   * @return the number of key-value pairs in this symbol table
   */
  public int size() {
    return N;
  }

  /**
   * Is this symbol table empty?
   * @return <tt>true</tt> if this symbol table is empty and <tt>false</tt> otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns all keys in the symbol table as an <tt>Iterable</tt>.
   * To iterate over all of the keys in the symbol table named <tt>st</tt>,
   * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
   * @return all keys in the sybol table as an <tt>Iterable</tt>
   */


  /**
   * Returns all of the keys in the set that start with <tt>prefix</tt>.
   * @param prefix the prefix
   * @return all of the keys in the set that start with <tt>prefix</tt>,
   *     as an iterable
   */


  /**
   * Returns all of the keys in the symbol table that match <tt>pattern</tt>,
   * where . symbol is treated as a wildcard character.
   * @param pattern the pattern
   * @return all of the keys in the symbol table that match <tt>pattern</tt>,
   *     as an iterable, where . is treated as a wildcard character.




   /**
   * Returns the string in the symbol table that is the longest prefix of <tt>query</tt>,
   * or <tt>null</tt>, if no such string.
   * @param query the query string
   * @return the string in the symbol table that is the longest prefix of <tt>query</tt>,
   *     or <tt>null</tt> if no such string
   * @throws NullPointerException if <tt>query</tt> is <tt>null</tt>
   */
  public CharArray longestPrefixOf(CharArray query) {
    int length = longestPrefixOf(root, query, 0, -1);
    if (length == -1) return null;
    else return query.substring(0, length);
  }

  // returns the length of the longest string key in the subtrie
  // rooted at x that is a prefix of the query string,
  // assuming the first d character match and we have already
  // found a prefix match of given length (-1 if no such match)
  private int longestPrefixOf(Node x, CharArray query, int d, int length) {
    if (x == null) return length;
    if (x.val != -1) length = d;
    if (d == query.length()) return length;
    char c = query.get(d);
    return longestPrefixOf(x.next[c], query, d+1, length);
  }

  /**
   * Removes the key from the set if the key is present.
   * @param key the key
   * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
   */
  public void delete(CharArray key) {
    root = delete(root, key, 0);
  }

  private Node delete(Node x, CharArray key, int d) {
    if (x == null) return null;
    if (d == key.length()) {
      if (x.val != -1) N--;
      x.val = -1;
    }
    else {
      char c = key.get(d);
      x.next[c] = delete(x.next[c], key, d+1);
    }

    // remove subtrie rooted at x if it is completely empty
    if (x.val != -1) return x;
    for (int c = 0; c < R; c++)
      if (x.next[c] != null)
        return x;
    return null;
  }


  public static void main(String[] args) {
    test(5);
  }

  public static void test(int val) {
    Main st = new Main();
    CharArray test = new CharArray(8);

    test.set(0, 'S');
    test.set(1, 'V');
    test.set(2, 'C');
    test.set(3, 'O');
    test.set(4, 'M');
    test.set(5, 'P');
    test.set(6, '2');
    test.set(7, '0');

    st.put(test, val);
    //assert (st.get(test) == val);
    assert false;
  }
}
