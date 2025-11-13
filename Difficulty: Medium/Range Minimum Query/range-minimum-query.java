class GfG{
    
    static int st[];

    public static int[] constructST(int arr[], int n){
        st = new int[4 * n];
        
        f(1, 0, n - 1, arr);
        
        return st;
    }
    
    private static void f(int node, int l, int r, int[] arr){
        if(l == r){
            st[node] = arr[l];
            return;
        }
        
        int mid = (l + r) >> 1;
        
        f(node * 2, l, mid, arr);
        f(node * 2 + 1, mid + 1, r, arr);
        
        st[node] = Math.min(st[node * 2], st[node * 2 + 1]);
    }

    public static int RMQ(int st[], int n, int l, int r){
        return findMin(1, 0, n - 1, l, r, st);
    }
    
    private static int findMin(int node, int L, int R, int l, int r, int[] st){
        // complete overlap
        if(L >= l && R <= r){
            return st[node];
        }
        
        // completely outside range
        if(l > R || r < L){
            return Integer.MAX_VALUE;
        }
        
        // partial overlap
        int mid = (L + R) >> 1;
        int left = findMin(node * 2, L, mid, l, r, st);
        int right = findMin(node * 2 + 1, mid + 1, R, l, r, st);
        
        return Math.min(left, right);
    }
}



