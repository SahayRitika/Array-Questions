class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
        for(int num: bills){
            if(num== 5){
                five++;
            }else if( num==10){
                ten++;
                if(five>0)five--;
                else return false;
            }else{
                if(five>0 && ten>0){five--; ten--;}
                else if( five>2) five-= 3;
                else return false;
            }
        }
        return true;
    }
}
