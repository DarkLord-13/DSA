class Solution{
    public int[][] generateMatrix(int n){
        int[][] ret = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1, total = n*n;

        while(num <= total){
            for(int j=left; j<=right; j++){
                ret[top][j] = num++;
            }
            top++;

            for(int i=top; i<=bottom; i++){
                ret[i][right] = num++;
            }
            right--;

            for(int j=right; j>=left; j--){
                ret[bottom][j] = num++;
            }
            bottom--;        

            for(int i=bottom; i>=top; i--){
                ret[i][left] = num++;
            }
            left++;        
        }

        return ret;
    }
}