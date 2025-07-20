class Solution{
    public boolean searchMatrix(int[][] g, int target){
        int n = g.length;

        for(int row=0; row<n; row++){
            if(bs(g[row], target)){
                return true;
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