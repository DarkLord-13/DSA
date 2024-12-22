class Solution{
    public int candy(int[] r){
        int n=r.length, sum=1, peak=1, down=1;

        int i=1;
        while(i<n){
            peak=1;
            while(i<n && r[i]>r[i-1]){
                peak++;
                sum+=peak;
                i++;
            }

            if(i<n && r[i]==r[i-1]){
                sum+=1;
                i++;
                continue;
            }            

            down=1;            
            while(i<n && r[i]<r[i-1]){                
                sum+=down;                                
                i++;
                down++;
            }
            
            if(down>peak) sum+=(down-peak);
        }


        return sum;        
    }
}