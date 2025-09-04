class Solution{
    private class Job{
        int s, e, p;

        public Job(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public String toString(){
            return s + " " + e + " " + p;
        }
    }

    private Job[] jobs;
    private int n;
    private Integer[] memo;

    public int jobScheduling(int[] start, int[] end, int[] profit){
        this.n = start.length;
        this.jobs = new Job[n];
        for(int i=0; i<n; i++) jobs[i] = new Job(start[i], end[i], profit[i]);
        this.memo = new Integer[n];

        Arrays.sort(jobs, (a, b)-> a.s - b.s);

        return f(0);
    }

    private int f(int i){
        if(i >= n) return 0;
        if(memo[i] != null) return memo[i];
        
        int not_take = f(i + 1);

        int idx = findNext(i);
        int take = jobs[i].p + f(idx);

        return memo[i] = Math.max(take, not_take);
    }

    private int findNext(int i){
        int l = i + 1, h = n - 1, ans = n;

        while(l <= h){
            int mid = (l + h) / 2;

            if(jobs[mid].s >= jobs[i].e){
                ans = mid;
                h = mid - 1;
            } 
            else{
                l = mid + 1;
            }
        }

        return ans;
    }
}