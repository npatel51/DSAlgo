import java.util.HashMap;

public class TrieNode {
    private HashMap<Character,TrieNode> children;
    private boolean isEndOfTheWord;

    TrieNode(){
        children = new HashMap<>();
    }
    TrieNode(char character){
        children = new HashMap<>();
        children.put(character,null);
    }
    TrieNode getChildren(char character){
          return children.get(character);
    }
    void  addChildren(char character, TrieNode children){
        this.children.put(character, children);
    }
    boolean hasChild(char character){
        return children.containsKey(character);
    }
    boolean isEnd(){
        return isEndOfTheWord;
    }
    void setEnd(){
        isEndOfTheWord  = true;
    }
    public String toString(){
        return children.toString();
    }
}

