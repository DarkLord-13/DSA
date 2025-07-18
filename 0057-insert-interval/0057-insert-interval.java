class Solution{
    public int[][] insert(int[][] intervals, int[] newi){
        List<List<Integer>> allIntervals = new ArrayList<>();
        boolean added = false;

        if(intervals.length == 0){
            return new int[][] {newi};
        }
        
        for(int[] i: intervals){
            if(i[0] >= newi[0] && !added){
                allIntervals.add(Arrays.asList(newi[0], newi[1]));
                added = true;
            }

            allIntervals.add(Arrays.asList(i[0], i[1]));            
        }
        if(!added){
            allIntervals.add(Arrays.asList(newi[0], newi[1]));
        }
        

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int len = allIntervals.size();

        int i = 1;
        int s = allIntervals.get(0).get(0);
        int e = allIntervals.get(0).get(1);

        while(i < len){

            int maxEnd = e;
            while(i < len && allIntervals.get(i).get(0) <= maxEnd){
                maxEnd = Math.max(maxEnd, allIntervals.get(i).get(1));
                i++;
            }

            mergedIntervals.add(Arrays.asList(s, maxEnd));

            if(i < len){
                s = allIntervals.get(i).get(0);
                e = allIntervals.get(i).get(1);
            }
        }

        int[][] res = new int[mergedIntervals.size()][2];
        for(i=0; i<res.length; i++){
            res[i][0] = mergedIntervals.get(i).get(0);
            res[i][1] = mergedIntervals.get(i).get(1);
        }

        return res;
    }
}