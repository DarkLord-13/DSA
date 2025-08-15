class Solution{
    public int[][] minCashFlow(int[][] transactions, int n){
        int[] net = new int[n];
        
        for(int from=0; from<n; from++){
            int[] t = transactions[from];
            
            for(int to=0; to<n; to++){
                int amt = t[to];
                net[from] -= amt;
                net[to] += amt;
                // System.out.println(amt);
            }
        }
        // System.out.println(Arrays.toString(net));
        
        transactions = new int[n][n];
        PriorityQueue<int[]> pos = new PriorityQueue<>((a, b)-> {
            return -a[1] + b[1];
        });
        PriorityQueue<int[]> neg = new PriorityQueue<>((a, b)-> {
            return a[1] - b[1];
        });
        
        for(int i=0; i<n; i++){
            if(net[i] > 0) pos.add(new int[] {i, net[i]});
            else if(net[i] < 0) neg.add(new int[] {i, net[i]});
        }
        // System.out.println(pos);
        // System.out.println(neg);
        
        while(!pos.isEmpty() && !neg.isEmpty()){
            int[] credit = pos.poll();
            int[] debit = neg.poll();
            
            int exchange = Math.min(credit[1], -1*debit[1]);
            transactions[debit[0]][credit[0]] += exchange;
            
            credit[1] -= exchange;
            debit[1] += exchange;
            
            if(credit[1] != 0) pos.add(credit);
            if(debit[1] != 0) neg.add(debit);
        }
        
        return transactions;
    }
}
/*
0: -100
1: -100
2: +200
*/