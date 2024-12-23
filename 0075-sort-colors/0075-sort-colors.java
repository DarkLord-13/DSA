class Solution{
    public void sortColors(int[] a){
        int n=a.length;
        int l=0, m=0, h=n-1; 

        while(m<=h){
            if(a[m]==0){
                swap(a, l, m);
                l++;
                m++;
            }
            else if(a[m]==1){
                m++;
            }
            else{
                swap(a, h, m);
                h--;
            }
        }

    }
    void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}