class Solution{
    public int[] resultsArray(int[] nums, int k){
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n; i++){            
            if(q.size() > 0 && q.peekFirst() <= i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.addLast(i);

            if(i >= k-1){
                l.add(nums[q.peekFirst()]);
            }
        } // System.out.println(l);

        List<Integer> gs = new ArrayList<>();
        gs.add(1);
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1){
                gs.add(gs.get(i-1)+1);
            }
            else{
                gs.add(1);
            }
        } // System.out.println(gs);

        int[] ret = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            int fromGs = gs.get(i+k-1);
            int num = l.get(i);

            if(fromGs >= k){
                ret[i] = num;
            }
            else{
                ret[i] = -1;
            }
        }

        return ret;
    }
}