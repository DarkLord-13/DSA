class Solution{
    public boolean lemonadeChange(int[] bills){
        int five=0, ten=0, twenty=0;

        for(int cash: bills){
            if(cash==5) five++;
            else if(cash==10) ten++;
            else twenty++; 

            while(cash>=20 && ten>0){
                cash-=10;
                ten--;
            }
            while(cash>=10 && five>0){
                cash-=5;
                five--;
            }
            if(cash>5) return false;                       
        }

        return true;
    }
}