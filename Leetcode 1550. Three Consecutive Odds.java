class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i,c=0;
        for(i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                c++;
            }else{
                c=0;
            }
            if(c==3){
                return true;
            }
        }
        return false;
    }
}
