class Solution{
    public long subArrayRanges(int[] a){
        int n = a.length;

        long[] pmin = preMin(a), smin = sufMin(a);
        long mint = 0;
        for(int i=0; i<n; i++){
            mint += ( (i-pmin[i])*(smin[i]-i)*a[i] );
        }

        long[] pmax = preMax(a), smax = sufMax(a);
        long maxt = 0;
        for(int i=0; i<n; i++){
            maxt += ( (i-pmax[i])*(smax[i]-i)*a[i] );
        }
        
        print(pmin); print(smin); print(pmax); print(smax);

        return -mint+maxt;
    }
    long[] preMin(int[] a){
        Stack<Integer> s = new Stack<>();
        int n = a.length; long[] ret = new long[n];

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]) s.pop();

            if(s.isEmpty()) ret[i]=-1;
            else ret[i]=s.peek();

            s.push(i);
        }

        return ret;
    }
    long[] sufMin(int[] a){
        Stack<Integer> s = new Stack<>();
        int n = a.length; long[] ret = new long[n];

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]>a[i]) s.pop();

            if(s.isEmpty()) ret[i]=n;
            else ret[i]=s.peek();

            s.push(i);
        }

        return ret;
    }
    long[] preMax(int[] a){
        Stack<Integer> s = new Stack<>();
        int n = a.length; long[] ret = new long[n];

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && a[s.peek()]<=a[i]) s.pop();

            if(s.isEmpty()) ret[i]=-1;
            else ret[i]=s.peek();

            s.push(i);
        }

        return ret;
    }
    long[] sufMax(int[] a){
        Stack<Integer> s = new Stack<>();
        int n = a.length; long[] ret = new long[n];

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]<a[i]) s.pop();

            if(s.isEmpty()) ret[i]=n;
            else ret[i]=s.peek();

            s.push(i);
        }

        return ret;
    }
    void print(long[] a){
        for(long i: a) System.out.print(i + " ");
        System.out.println();
    }
}