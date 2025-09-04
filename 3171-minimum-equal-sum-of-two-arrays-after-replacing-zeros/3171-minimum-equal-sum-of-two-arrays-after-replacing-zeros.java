class Solution{
    public long minSum(int[] nums1, int[] nums2){
        long sum1 = 0, sum2 = 0;
        long z1 = 0, z2 = 0;

        for(int num: nums1){
            if(num == 0){
                z1++;
            }
            else{
                sum1 += num;
            }
        }

        for(int num: nums2){
            if(num == 0){
                z2++;
            }
            else{
                sum2 += num;
            }
        }

        if(z1 > 0 && z2 > 0){
            return Math.max(sum1 + z1, sum2 + z2);
        }
        else if(z1 == 0 && z2 > 0){
            if(sum1 >= sum2 + z2) return sum1;
            else return -1;
        }
        else if(z2 == 0 && z1 > 0){
            if(sum2 >= sum1 + z1) return sum2;
            else return -1;
        }
        else{
            if(sum1 == sum2) return sum1;
            else return -1;
        }
    }
}