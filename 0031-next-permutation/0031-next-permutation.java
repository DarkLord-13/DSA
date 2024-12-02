class Solution{
    public void nextPermutation(int[] a){
        int n = a.length;
        int pivot = 0; boolean largest = true;
        for(int i=n-1; i>0; i--){
            if(a[i-1]<a[i]){
                pivot = i-1;
                largest = false;
                break;
            }
        } System.out.println(pivot);
        if(largest){
            Arrays.sort(a);
            return;
        }

        for(int i=n-1; i>pivot; i--){
            if(a[i]>a[pivot]){
                int temp = a[i];
                a[i] = a[pivot];
                a[pivot] = temp;
                break;
            }
        } print(a);

        int sl = n-pivot-1; System.out.println(sl);
        for(int i=pivot+1, j=n-1; i<=pivot + sl/2; i++){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
        }
    }

    void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}