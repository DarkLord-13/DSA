class Solution{
    
    private class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private void buildTree(String[] words){
        for(String word: words){
            TrieNode node = root;

            for(char c: word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }

            node.word = word;
        }
    }
    
    private final int[] x = {-1, 0, 1, 0};
    private final int[] y = {0, 1, 0, -1};

    private TrieNode root;
    private List<String> res;
    private char[][] g;
    private int m, n;

    public List<String> findWords(char[][] g, String[] words){
        this.m = g.length;
        this.n = g[0].length;
        this.root = new TrieNode();
        this.res = new ArrayList<>();
        this.g = g;

        buildTree(words);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                int idx = g[i][j] - 'a';
                
                if(root.children[idx] != null){ // a word starts from the same letter in words[]
                    TrieNode parent = root.children[idx];
                    dfs(i, j, parent);
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, TrieNode parent){
        char ch = g[r][c];
        if(g[r][c] == '#') return;

        if(parent.word != null){
            res.add(parent.word);
            parent.word = null;
        }

        g[r][c] = '#';

        for(int p=0; p<4; p++){
            int i = r + x[p], j = c + y[p];
            if(i < 0 || j < 0 || i >= m || j >= n || g[i][j] == '#') continue;
            int nidx = g[i][j] - 'a';

            if(parent.children[nidx] != null){
                dfs(i, j, parent.children[nidx]);
            }
        }

        g[r][c] = ch;
    }
}