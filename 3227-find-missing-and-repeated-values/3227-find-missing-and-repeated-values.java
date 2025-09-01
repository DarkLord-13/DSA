class Solution{
    public int[] findMissingAndRepeatedValues(int[][] g){
        int n = g.length, k = 0;
        int[] nums = new int[n * n];
        int as = 0;
        int N = n * n;
        int ts = (N * (N + 1)) / 2;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                as += g[i][j];
                nums[k++] = g[i][j];
            }
        }

        int dup = findDuplicate(nums);
        as -= dup;
        int miss = ts - as;

        return new int[] {dup, miss};
    }
    private int findDuplicate(int[] nums){
        int n = nums.length;
        int i = 0;

        while(i < n){
            int currNum = nums[i];

            if(currNum != i + 1){
                int actualIndex = currNum - 1;
                if(nums[actualIndex] == currNum){
                    return currNum;
                }
                else{
                    swap(i, actualIndex, nums);
                }
            }
            else{
                i++;
            }
        }

        return -1;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// 1 2 3 4 = 10
// 1 2 2 4 = 9