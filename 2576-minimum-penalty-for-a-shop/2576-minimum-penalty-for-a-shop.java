class Solution{
    public int bestClosingTime(String customers){
        char[] s = customers.toCharArray();
        int n = s.length;
        
        int[] wrongNo = new int[n + 1];
        int[] wrongYes = new int[n + 1];

        for(int i=0; i<n; i++){
            wrongNo[i+1] = wrongNo[i];
            if(s[i] == 'N') wrongNo[i+1] += 1;
        }

        for(int i=n-1; i>=0; i--){
            wrongYes[i] = wrongYes[i+1];
            if(s[i] == 'Y') wrongYes[i] += 1;
        }

        // System.out.println(Arrays.toString(wrongYes));
        // System.out.println(Arrays.toString(wrongNo));

        int minPenalty = Integer.MAX_VALUE;
        int bestIndex = -1;

        for(int i=0; i<=n; i++){
            if(wrongNo[i] + wrongYes[i] < minPenalty){
                minPenalty = wrongNo[i] + wrongYes[i];
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}
// 0 0 0 1 1
// 3 2 1 1 0