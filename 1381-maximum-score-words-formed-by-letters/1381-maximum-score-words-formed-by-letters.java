class Solution{

    private int best = 0;
    private int[] avail, wscore;
    private int[][] wf;
    private int n;

    public int maxScoreWords(String[] words, char[] letters, int[] score){
        this.n = words.length;
        this.avail = new int[26];
        for(char c: letters){
            avail[c - 'a']++;
        }

        this.wf = new int[n][26];
        this.wscore = new int[n];
        int remainScore = 0;
        for(int i=0; i<n; i++){

            String w = words[i];
            for(char c: w.toCharArray()){
                wf[i][c - 'a']++;
                wscore[i] += score[c - 'a'];
            }

            remainScore += wscore[i];
        }

        dfs(0, 0, remainScore);

        return best;
    }

    private void dfs(int i, int curr, int remainScore){
        if(i == n){
            best = Math.max(best, curr);
            return;
        }

        if(curr + remainScore <= best) return;

        dfs(i + 1, curr, remainScore - wscore[i]);

        boolean can = true;
        for(int c=0; c<26; c++){
            if(wf[i][c] > avail[c]){
                can = false;
                break;
            }
        }

        if(can){
            for(int c=0; c<26; c++){
                avail[c] -= wf[i][c];
            }

            dfs(i + 1, curr + wscore[i], remainScore - wscore[i]);

            for(int c=0; c<26; c++){
                avail[c] += wf[i][c];
            }
        }
    }
}