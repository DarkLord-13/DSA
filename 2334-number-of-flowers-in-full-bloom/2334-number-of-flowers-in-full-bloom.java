class Solution{
    public int[] fullBloomFlowers(int[][] flowers, int[] people){
        int n = flowers.length;
        int[] start = new int[n], end = new int[n];
        for(int i=0; i<n; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));

        int[] answer = new int[people.length];
        for(int i=0; i<people.length; i++){
            answer[i] = lse(start, people[i]) - ls(end, people[i]);
        }

        return answer;
    }

    private int lse(int[] a, int x){
        int n = a.length;
        int l = 0, h = n - 1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(a[mid] > x){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return l + 1;
    }

    private int ls(int[] a, int x){
        int n = a.length;
        int l = 0, h = n - 1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(a[mid] >= x){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return l + 1;
    }
}
/**
1 2 3 4 5 6 7 8 9 10 11 12
1 1 2
 */