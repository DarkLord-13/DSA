class Solution{
    public void rotate(int[][] g){
        int n = g.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                inverse(i, j, g);
            }
        }

        for(int i=0; i<n; i++){
            int l = 0, h = n-1;

            while(l < h){
                swap(i, l, h, g);
                l++;
                h--;
            }
        }
    }

    private void swap(int i, int l, int h, int[][] g){
        int temp = g[i][l];
        g[i][l] = g[i][h];
        g[i][h] = temp;
    }

    private void inverse(int i, int j, int[][] g){
        int temp = g[i][j];
        g[i][j] = g[j][i];
        g[j][i] = temp;
    }
}