class Solution{
    public boolean searchMatrix(int[][] g, int target){
        int m = g.length, n = g[0].length;
        int i = m-1, j = 0;

        while(i >= 0 && j < n){
            if(g[i][j] == target){
                return true;
            }
            else if(g[i][j] < target){
                j++;
            }
            else{
                i--;
            }
        }        

        return false;
    }
    boolean bs(int[] row, int target){
        int l = 0, h = row.length - 1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(row[mid] == target){
                return true;
            }
            else if(target > row[mid]){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }

        return false;
    }
}