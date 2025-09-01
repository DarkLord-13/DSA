class Solution{
    public List<Integer> majorityElement(int[] nums){
        int n = nums.length;
        int one = 0, two = 0;
        int oc = 0, tc = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == one){
                oc++;
            }
            else if(nums[i] == two){
                tc++;
            }
            else if(oc == 0){
                oc = 1;
                one = nums[i];
            }
            else if(tc == 0){
                tc = 1;
                two = nums[i];
            }
            else{
                oc--;
                tc--;
            }
        }
        // System.out.println(one + " " + two);

        oc = 0; tc = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == one){
                oc++;
            }
            else if(nums[i] == two){
                tc++;
            }
        }

        List<Integer> l = new ArrayList<>();
        if(oc > (n / 3)) l.add(one);
        if(tc > (n / 3)) l.add(two);

        return new ArrayList<>(l);
    }
}