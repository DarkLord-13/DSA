class Solution{
    public int scheduleCourse(int[][] courses){
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)-> b - a);
        int total = 0, completed = 0;

        Arrays.sort(courses, (a, b)-> a[1] - b[1]);

        for(int[] course: courses){
            int d = course[0], l = course[1];

            total += d;
            q.add(d);

            if(total > l) total -= q.poll();
        }
        
        return q.size();
    }
}