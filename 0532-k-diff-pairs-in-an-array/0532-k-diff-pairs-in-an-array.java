class Solution{
    public int findPairs(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // System.out.println(map);

        if(k == 0){

            int c = 0;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int f = entry.getValue();

                if(f > 1){
                    c++;
                }
            }

            return c;
        }
        else{
            int c = 0;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int key = entry.getKey();
                int f = entry.getValue();

                if(map.containsKey(key - k)){
                    // System.out.println(key + " " + k + " " + Math.abs(key - k));
                    c++;
                } 

                // System.out.println(c);               
            }

            return c;
        }
    }
}

/*
3 1 4 1 5

1 1 3 4 5

1 - 2
3 - 1
4 - 1
5 - 1
*/
//3271