class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval){
        ArrayList<int[]> l = new ArrayList<>();
        int i=0, n=intervals.length;
        // left side no overlapping
        while(i<n && intervals[i][1]<newInterval[0]){
            l.add(intervals[i]);
            i++;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // overlapping middle
        while(i<n && intervals[i][0]<=newInterval[1]){
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
            i++;
        }
        min = Math.min(min, newInterval[0]);
        max = Math.max(max, newInterval[1]);

        int[] insert = new int[2];
        insert[0] = min; insert[1] = max;
        l.add(insert);

        while(i<n){
            l.add(intervals[i]);
            i++;
        }

        int[][] ret = new int[l.size()][2];
        for(i=0; i<l.size(); i++){
            ret[i] = l.get(i);
        }

        return ret;
    }
}