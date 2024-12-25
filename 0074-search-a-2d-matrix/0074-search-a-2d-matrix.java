class Solution{
    public boolean searchMatrix(int[][] a, int t){
        int m = a.length, n = a[0].length;
        int rs = 0, re = m-1, rm = (rs+re)/2;
        
        while(rs<re){
            if(a[rm][n-1]>t) re = rm-1;            
            else if(a[rm][n-1]<t) rs = rm+1;            
            else return true;

            rm = (rs+re)/2;
        }
        if(a[rs][n-1]==t) return true;
        else if(a[rs][n-1]<t) rs++;
        
        if(rs>=m) return false;

        int[] arr = a[rs];
        int s = 0, e = n-1, mid = (s+e)/2;

        while(s<e){
            if(arr[mid]<t) s = mid+1;            
            else if(arr[mid]>t) e = mid-1;            
            else return true;

            mid = (s+e)/2;
        }    

        if(arr[mid]==t) return true;  
        return false;
    }
}