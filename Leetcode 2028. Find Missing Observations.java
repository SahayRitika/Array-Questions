class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m= rolls.length;
        int sumTotal= mean * (m+n);
        int currSum=0, remaining_sum=0;

        for(int roll : rolls){
            currSum+= roll;
        }

        remaining_sum= sumTotal- currSum;

        if(remaining_sum < n || remaining_sum > 6*n){
            return new int[0];
        }

        int base= remaining_sum/n;
        int remainder= remaining_sum%n;

        int result[]= new int[n];
        for(int i=0; i<n; i++){
            result[i]= base + (i<remainder? 1:0);
        }

        return result;
    }
}
