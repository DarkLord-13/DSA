class Solution{
    public char[][] rotateTheBox(char[][] og){
        int m = og.length, n = og[0].length;
        char[][] ng = new char[n][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ng[j][i] = og[i][j];                
            }
        }
        for(int i=0; i<n; i++){
            int l = 0, h = m-1;

            while(l < h){
                char temp = ng[i][l];
                ng[i][l] = ng[i][h];
                ng[i][h] = temp;

                l++; h--;
            }
        }
        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(ng[i]));
        // }

        for(int col=0; col<m; col++){
            int write = n-1;

            for(int read=n-1; read>=0; read--){
                if(ng[read][col] == '*'){
                    write = read - 1;
                }
                else if(ng[read][col] == '#'){

                    if(read < write){
                        ng[write][col] = '#';
                        ng[read][col] = '.';
                    }

                    write--;
                }
            }
        }

        return ng;
    }
}