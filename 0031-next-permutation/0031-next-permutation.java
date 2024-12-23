class Solution{
    public void nextPermutation(int[] a){
        int n=a.length, i=n-2;

        if(n<=1) return;

        while(i>=0 && a[i]>=a[i+1]) i--;
        System.out.println(i);
        if(i<0) i=0;

        int j, minj=n, smallestLargestNumber=Integer.MAX_VALUE;
        for(j=i+1; j<n; j++){
            if(a[j]>a[i]){
                if(a[j]<smallestLargestNumber){
                    smallestLargestNumber = a[j];
                    minj = j;
                }
            }
        } System.out.println(minj);
        if(minj==n && i==0){
            Arrays.sort(a);
            return;
        }
        else if(minj==n) minj=n-1;

        int temp = a[i];
        a[i] = a[minj];
        a[minj] = temp;

        Arrays.sort(a, i+1, n);
    }
}