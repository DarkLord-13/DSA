class Trie{
    
    private class TrieNode{
        TrieNode[] children;
        boolean end;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.end = false;
        }
    }

    private TrieNode parent;

    public Trie(){
        this.parent = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode root = parent;

        for(char c: word.toCharArray()){
            if(root.children[c - 'a'] == null) root.children[c - 'a'] = new TrieNode();  

            root = root.children[c - 'a'];
        }

        root.end = true;
    }
    
    public boolean search(String word){
        TrieNode root = parent;

        for(char c: word.toCharArray()){
            if(root.children[c - 'a'] == null) return false;

            root = root.children[c - 'a'];
        }

        return root.end;
    }
    
    public boolean startsWith(String prefix){
        TrieNode root = parent;

        for(char c: prefix.toCharArray()){
            if(root.children[c - 'a'] == null) return false; 

            root = root.children[c - 'a'];
        }

        return true;
    }
}