public class Trie {

    private TrieNode root;

    Trie(){
        root = new TrieNode(' ');
    }
    /**
     * Trie provides two main functionality: insert and search
     */
    void insert( String s ){
        TrieNode curr =  root;
        for(int i=0;i<s.length();++i) {
            //if trie contains a character update the curr node to the associated child node
            // if not in the tree add a character as current node's child
            if( !curr.hasChild(s.charAt(i)) ){
               curr.addChildren(s.charAt(i),new TrieNode());
            }
            curr = curr.getChildren(s.charAt(i));
        }
        curr.setEnd(); //setting the end of the word to be true
    }

    boolean search( String s ){
        TrieNode  curr = root;
        for( int i=0; i< s.length() ; ++i ) {
            // if the trie does not have a node search can be terminated
            if( !curr.hasChild(s.charAt(i))) {
                return false;
            }
            curr  = curr.getChildren(s.charAt(i)); // move to the child node
        }
        //if curr is null string is not in trie, if it isn't check if it's the end of the word
        return curr.isEnd();
    }

    public String toString(){
        return root.toString();
    }
}

