class Solution{
    public boolean searchMatrix(int[][] a, int t){
        int m = a.length, n = a[0].length;
        int i = 0, j = n-1;
        
        //if(a[i][j]==t) return true;
        while(i<m && a[i][j]<t){
            i++;
        }
        while(j>=0 && i<m && a[i][j]>t){
            j--;
        }
        if(i>=0 && i<m && j>=0 && j<n){
            if(a[i][j]==t) return true;
        }

        return false;
    }
}