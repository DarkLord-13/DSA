class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] nge = new int[nums2.length];

        for(int i=nums2.length-1; i>=0; i--){
            while(!st.isEmpty()){
                if(st.peek() <= nums2[i]) st.pop();
                else break;
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = nge[map.get(nums1[i])];
        }

        return ans;
    }
}