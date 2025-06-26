class Solution{
    public boolean searchMatrix(int[][] g, int target){
        int m = g.length, n = g[0].length;

        if(m==1 && n==1){
            return g[0][0] == target;
        }
        
        int s = 0, e = m-1;
        while(s <= e){
            int mid = (s + e) >> 1;

            if(target < g[mid][n-1]){
                e = mid - 1;
            }
            else if(target > g[mid][n-1]){
                s = mid + 1;
            }
            else{
                return true;
            }
        } // System.out.println(s);
        int row = s;

        if(row >= m){
            return false;
        }

        s = 0; e = n-1;
        while(s <= e){
            int mid = (s + e) >> 1;

            if(target < g[row][mid]){
                e = mid - 1;
            }
            else if(target > g[row][mid]){
                s = mid + 1;
            }
            else{
                return true;
            }
        }

        return false;
    }
}