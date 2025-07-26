class Solution{
    List<List<String>> ll;
    int n;
    public List<List<String>> solveNQueens(int n){
        this.n = n;
        this.ll = new ArrayList<>();
        char[][] g = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(g[i], '.');
        }

        f(0, g);

        return ll;
    }

    List<String> convert(char[][] g){
        List<String> l = new ArrayList<>();
        for(char[] row: g){
            l.add(new String(row));
        }

        return l;
    }

    void f(int col, char[][] g){
        if(col == n){
            ll.add(convert(g));
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row, col, g)){
                g[row][col] = 'Q';
                f(col+1, g);
                g[row][col] = '.';
            }
        }
    }

    boolean isSafe(int r, int c, char[][] g){
        // check for same row
        int j = 0, count = 0;
        while(j < n){
            if(g[r][j] == 'Q') count++;

            j++;
        }
        if(count > 0) return false;

        // check for same col
        int i = 0; count = 0;
        while(i < n){
            if(g[i][c] == 'Q') count++;

            i++;
        }
        if(count > 0) return false;

        // check for diagonal up-left
        count = 0;
        i = r-1; j = c-1;
        while(i >= 0 && j >= 0){
            if(g[i][j] == 'Q') count++;

            i--; j--;
        }

        // check for diagonal up-right
        i = r-1; j = c+1;
        while(i >= 0 && j < n){
            if(g[i][j] == 'Q') count++;
            
            i--; j++;
        }

        // check for diagonal down-left
        i = r+1; j = c-1;
        while(i < n && j >= 0){
            if(g[i][j] == 'Q') count++;
            
            i++; j--;
        }

        // check for diagonal down-right
        i = r+1; j = c+1;
        while(i < n && j < n){
            if(g[i][j] == 'Q') count++;
            
            i++; j++;
        }

        if(count > 0) return false;

        return true;
    }
}