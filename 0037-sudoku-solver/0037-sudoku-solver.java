class Solution{
    int n=9;
    public void solveSudoku(char[][] b){
        boolean x = f(b);
    }
    boolean f(char[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(b[i][j]=='.'){
                    for(int num=1; num<=9; num++){
                        if(isSafe(i, j, num, b)){
                            b[i][j] = (char)(num+'0');

                            if(f(b)) return true;
                            else b[i][j] = '.';

                        }
                    }

                    return false;
                }
            }
        }

        return true;        
    }
    boolean isSafe(int x, int y, int num, char[][] b){
        for(int i=0; i<n; i++){ // check column
            if(b[i][y]==(char)(num+'0')) return false;
        }
        for(int i=0; i<n; i++){ // check row
            if(b[x][i]==(char)(num+'0')) return false;
        }

        int firstRow = (x/3)*3, firstCol = (y/3)*3;
        for(int i=firstRow; i<firstRow+3; i++){
            for(int j=firstCol; j<firstCol+3; j++){

                if(b[i][j]==(char)(num+'0')) 
                    return false;
            }
        }

        return true;
    }
}