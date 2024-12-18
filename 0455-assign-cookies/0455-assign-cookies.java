class Solution{
    public int findContentChildren(int[] g, int[] c){
        Arrays.sort(g); Arrays.sort(c);
        int i=0, j=0;

        while(j<c.length && i<g.length){
            if(c[j]>=g[i]){
                i++;
            }
            j++;
        }

        return i;
    }
}