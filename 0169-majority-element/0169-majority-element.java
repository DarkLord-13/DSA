class Solution{
    public int majorityElement(int[] a){
        int count = 0;
        int maj = a[0];

        for(int num: a){
            if(num == maj){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    maj = num;
                    count = 1;
                }
            }
        }

        return maj;
    }
}