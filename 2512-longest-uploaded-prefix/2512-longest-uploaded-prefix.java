class LUPrefix{

    private int n, curr;
    private boolean[] uploaded;

    public LUPrefix(int n){
        this.n = n + 1;
        this.curr = 0;
        this.uploaded = new boolean[n + 1];
    }
    
    public void upload(int v) {
        uploaded[v] = true;

        while(curr + 1 < n && uploaded[curr + 1]) curr++;
    }
    
    public int longest() {
        return curr;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */