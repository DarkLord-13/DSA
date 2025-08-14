class Trie{

    private class TrieNode{
        TrieNode[] root;
        boolean end = false;

        public TrieNode(){
            this.root = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;

        for(char c: word.toCharArray()){            
            if(node.root[c - 'a'] == null){
                node.root[c - 'a'] = new TrieNode();
            }

            node = node.root[c - 'a'];
        }

        node.end = true;
    }
    
    public boolean search(String word){
        TrieNode node = root;

        for(char c: word.toCharArray()){
            node = node.root[c - 'a'];

            if(node == null) return false;
        }

        if(!node.end) return false;
        else return true;
    }
    
    public boolean startsWith(String word){
        TrieNode node = root;

        for(char c: word.toCharArray()){
            node = node.root[c - 'a'];

            if(node == null) return false;
        }

        return true;
    }
}