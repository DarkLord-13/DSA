class Solution{
    List<List<String>> ans = new ArrayList<>(); int n;
    public List<List<String>> solveNQueens(int nx){
        n = nx; char[][] board = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], '.');

        solve(0, board);

        return ans;
    }
    void solve(int col, char[][] board){
        if(col==n){
            ans.add(construct(board));
            return;
        }

        for(int i=0; i<n; i++){
            if(isSafe(i, col, board)){
                board[i][col] = 'Q';
                solve(col+1, board);
                board[i][col] = '.';
            }
        }
    }
    boolean isSafe(int r, int c, char[][] board){
        for(int i=0; i<n; i++){
            if(board[i][c]=='Q') return false;
        }

        for(int j=0; j<n; j++){
            if(board[r][j]=='Q') return false;
        }

        int i=r, j=c;
        while(i<n&&j<n){ //upper right
            if(board[i][j]=='Q') return false;
            i++; j++;
        }

        i=r; j=c;
        while(i>=0&&j>=0){ //bottom left
            if(board[i][j]=='Q') return false;
            i--; j--;
        }

        i=r; j=c;
        while(i>=0&&j<n){ //bottom right
            if(board[i][j]=='Q') return false;
            i--; j++;
        }

        i=r; j=c;
        while(i<n&&j>=0){ //upper left
            if(board[i][j]=='Q') return false;
            i++; j--;
        }

        return true;
    }
    List<String> construct(char[][] board){
        List<String> ret = new ArrayList<>();
        for(char[] iter: board){
            String row = new String(iter);
            ret.add(row);
        }

        return ret;
    }
}