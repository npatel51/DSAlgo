public class TestTrie {

    public static void main(String[] args){
      String words[] = {"this","is","trie"};
      Trie trie = new Trie();

      for( String s : words ){
          trie.insert(s);
      }
      System.out.println(trie);
      System.out.println(trie.search("thi"));
      System.out.println(trie.search("this"));
      System.out.println(trie.search("thise"));
      System.out.println(trie.search("trie"));
      System.out.println(trie.search("t"));
      System.out.println(trie.search("triee"));
    }
}
