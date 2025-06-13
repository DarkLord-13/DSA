class Solution{
    static int inversionCount(int[] arr){
        return mergeSortAndCount(0, arr.length - 1, arr);
    }
    static private int mergeSortAndCount(int l, int r, int[] arr){
        if(l >= r){
            return 0;
        }
        
        int m = (l + r) >> 1;
        
        int count = 0;
        
        count += mergeSortAndCount(l, m, arr);
        count += mergeSortAndCount(m+1, r, arr);
        count += mergeAndCount(l, m, r, arr);
        
        return count;
    }
    static private int mergeAndCount(int l, int m, int r, int[] arr){
        int n1 = m-l+1, n2 = r-m;
        int[] a = Arrays.copyOfRange(arr, l, m+1), b = Arrays.copyOfRange(arr, m+1, r+1);
        int count = 0;
        
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(a[i] <= b[j]){
                arr[k++] = a[i++];
            }
            else{
                arr[k++] = b[j++];
                count += (n1 - i);
            }
        }
        
        while(i < n1){
            arr[k++] = a[i++];
        }
        
        while(j < n2){
            arr[k++] = b[j++];
        }
        
        return count;
    }
}