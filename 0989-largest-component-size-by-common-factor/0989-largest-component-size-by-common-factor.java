class Solution{

    private int[] p, r;

    private int find(int x){
        if(p[x] != x){
            p[x] = find(p[x]);
        }

        return p[x];
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }
        else if(r[x] > r[y]){
            p[y] = p[x];
        }
        else if(r[y] > r[x]){
            p[x] = p[y];
        }
        else{
            p[y] = p[x];
            r[x]++;
        }
    }

    public int largestComponentSize(int[] nums){
        int n = nums.length;
        this.p = new int[n];
        for(int i=0; i<n; i++) p[i] = i;
        this.r = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int x = nums[i];
            int val = x;

            for(int pr=2; pr*pr<=val; pr++){
                if(val % pr == 0){

                    if(map.containsKey(pr)){
                        union(map.get(pr), i);
                    }
                    else{
                        map.put(pr, i);
                    }
                }

                while(val % pr == 0){
                    val /= pr;
                }
            }

            if(val > 1){
                if(map.containsKey(val)){
                    union(map.get(val), i);
                }
                else{
                    map.put(val, i);
                }
            }
        }        

        for(int i=0; i<n; i++){
            p[i] = find(i);
        }

        Map<Integer, Integer> count = new HashMap<>();
        int max = 1;
        for(int i=0; i<n; i++){
            int root = find(i);
            int f = count.getOrDefault(root, 0) + 1;
            count.put(root, f);

            if(f > max){
                max = f;
            }
        }

        return max;
    }
}