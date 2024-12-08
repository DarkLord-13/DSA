class Solution{
    public int[] maxSlidingWindow(int[] a, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        int n = a.length; int[] ret = new int[n-k+1];

        /*int i = 0, j = 0;
        for(i=j; i<k; i++){
            while(dq.size()>0 && dq.peekLast()<=a[i]){
                dq.pollLast();
            }
            

            dq.addLast(a[i]); if(dq.size()>k) dq.pollFirst();
        }
        ret[0] = dq.peekFirst();

        j = i;*/
        for(int i=0; i<n; i++){
            //System.out.println(dq);
            while(dq.size()>0 && i-dq.peekFirst()>=k) 
                dq.pollFirst();
            while(dq.size()>0 && a[dq.peekLast()]<=a[i])
                dq.pollLast();
            
            dq.addLast(i);

            //if(dq.size()>k) dq.pollFirst();

            if(i>=(k-1)) ret[i-(k-1)] = a[dq.peekFirst()];            
        }

        return ret;
    }
}