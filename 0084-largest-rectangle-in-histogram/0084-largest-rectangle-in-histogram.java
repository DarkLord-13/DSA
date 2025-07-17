class Solution{
    public int largestRectangleArea(int[] h){
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n], nse = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        System.out.println(Arrays.toString(pse));
        System.out.println(Arrays.toString(nse));

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, (nse[i] - pse[i] - 1) * h[i]);
        }

        return max;
    }
}