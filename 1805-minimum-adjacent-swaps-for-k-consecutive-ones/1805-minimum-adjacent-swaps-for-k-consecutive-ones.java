class Solution{
    public int minMoves(int[] nums, int k){
        int n = 0;
        for(int num: nums){
            if(num == 1) n++;
        }

        int[] arr = new int[n];
        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] == 1) arr[i++] = j;
        }

        for(i=0; i<n; i++){
            arr[i] = arr[i] - i;
        }

        int[] ps = new int[n];
        ps[0] = arr[0];
        for(i=1; i<n; i++){
            ps[i] = arr[i] + ps[i - 1];
        }

        int l = 0, r = k - 1, minCost = Integer.MAX_VALUE;
        while(r < n){
            // 1.
            int mid = k % 2 == 0 ? (l + (k / 2) - 1) : l + (k / 2);

            // 3.
            int leftCount = (mid - 1) - l + 1;
            int rightCount = r - (mid + 1) + 1;

            int leftSum = 0;
            if(mid > 0) leftSum += ps[mid - 1];
            if(l > 0) leftSum -= ps[l - 1];
            int rightSum = 0;
            if(rightCount > 0) rightSum = ps[r] - ps[mid];

            int leftCost = (leftCount * arr[mid]) - leftSum;
            int rightCost = (rightSum - (rightCount * arr[mid]));
            int totalCost = leftCost + rightCost;
            minCost = Math.min(minCost, totalCost);

            r++;
            l++;
        }

        return minCost;
    }
}