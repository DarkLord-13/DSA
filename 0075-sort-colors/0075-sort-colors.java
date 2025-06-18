class Solution{
    public void sortColors(int[] a){
        int n = a.length;
        int zero = 0, one = 0, two = n-1, i = 0;

        while(i <= two){
            if(a[i] == 0){
                swap(i, zero, a);
                zero++;
                i++;
            }
            else if(a[i] == 2){
                swap(i, two, a);
                two--;
            }
            else{
                i++;
            }
        }
    }
    void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}