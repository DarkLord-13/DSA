class Solution{
    public boolean lemonadeChange(int[] bills){
        int five=0, ten=0, twenty=0;

        for(int cash: bills){
            if(cash==5) five++;
            else if(cash==10) ten++;
            else twenty++;

            while(cash>=25 && twenty>0){
                cash-=20;
                twenty--;
            }
            while(cash>=15 && ten>0){
                cash-=10;
                ten--;
            }
            while(cash>5 && five>0){
                cash-=5;
                five--;
            }

            if(cash>5) return false;                       
        }

        return true;
    }
}