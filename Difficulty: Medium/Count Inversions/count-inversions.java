class Solution{
    static int[] arr;
    static int inversionCount(int[] arrx){
        arr = arrx;
        
        return merge(0, arr.length - 1);
    }
    static int merge(int l, int r){
        if(l >= r){
            return 0;
        }
        
        int mid = (l + r) >> 1;
        
        int count = 0;
        
        count += merge(l, mid);
        count += merge(mid+1, r);
        count += mergeSort(l, mid, r);
        
        return count;
    }
    static int mergeSort(int l, int mid, int r){
        int[] arr1 = Arrays.copyOfRange(arr, l, mid+1);
        int[] arr2 = Arrays.copyOfRange(arr, mid+1, r+1);
        int n1 = arr1.length, n2 = arr2.length;
        
        int i = 0, j = 0, k = l, count = 0;
        
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                arr[k++] = arr1[i++];
            }
            else{
                count += (n1 - i);
                arr[k++] = arr2[j++];
            }
        }
        
        while(i < n1){
            arr[k++] = arr1[i++];
        }
        
        while(j < n2){
            arr[k++] = arr2[j++];
        }
        
        return count;
    }
}