class Solution{
    public int maxArea(int[] a){
        int l = a.length, maxi = Integer.MIN_VALUE, i = 0, j = l-1;
        while(i<j){
            int prod = Math.min(a[i], a[j]) * Math.abs(i-j);
            maxi = Math.max(maxi, prod);
            if(a[i]<=a[j]) i++;
            else j--;
        }        

        return maxi;
    }
}