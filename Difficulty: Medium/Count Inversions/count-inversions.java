class Solution{
    int inversionCount(int arr[]){
        int x = mergeSort(0, arr.length - 1, arr);
        // System.out.println(Arrays.toString(arr));
        return x;
    }
    
    private int mergeSort(int l, int r, int[] arr){
        if(r - l <= 0){
            return 0;
        }
        
        int mid = (r - l) / 2;
        mid = l + mid;
        
        int left = mergeSort(l, mid, arr);
        int right = mergeSort(mid + 1, r, arr);
        int count = mergeAndCount(l, mid, r, arr);
        
        return left + right + count;
    }
    
    private int mergeAndCount(int l, int mid, int r, int[] arr){
        int[] a = Arrays.copyOfRange(arr, l, mid + 1);
        int[] b = Arrays.copyOfRange(arr, mid + 1, r + 1);
        
        int al = a.length, bl = b.length;
        int i = 0, j = 0, k = l;
        int count = 0;
        
        while(i < al && j < bl){
            if(a[i] <= b[j]){
                arr[k++] = a[i++];
            }
            else{
                count += (al - i);
                arr[k++] = b[j++];
            }
        }
        
        while(i < al){
            arr[k++] = a[i++];
        }
        
        while(j < bl){
            arr[k++] = b[j++];
        }
        
        return count;
    }
}