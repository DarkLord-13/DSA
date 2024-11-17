class Solution{
    int[] a; int n;
    public int[] countBits(int nx){
        n = nx; a = new int[n+1];
        if(n==0) return a;

        f(1, 1);
        return a;
    }
    void f(int i, int b){
        if(i>n) return;
        a[i] = b;

        i*=2;
        f(i, b);
        f(i+1, b+1);
    }
}