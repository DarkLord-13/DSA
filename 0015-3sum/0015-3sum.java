class Solution{
    public List<List<Integer>> threeSum(int[] a){
        Arrays.sort(a);
        int n = a.length;
        List<List<Integer>> ll = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i > 0 && a[i] == a[i-1]){
                continue;
            }

            int l = i+1, r = n-1;

            while(l < r){              
                int sum = a[i] + a[l] + a[r];
                if(sum < 0){
                    l++;
                }
                else if(sum > 0){
                    r--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(a[i]);
                    list.add(a[l]);
                    list.add(a[r]);
                    ll.add(new ArrayList<>(list));

                    while(l < r && a[l] == a[l+1]){
                        l++;
                    }
                    while(l < r && a[r] == a[r-1]){
                        r--;
                    }

                    l++;
                    r--;
                }
            }
        }

        return ll;
    }
}