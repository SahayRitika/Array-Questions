
//Solution One
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int val=0,i= happiness.length-1;

        while(k>0){
            if(happiness[i]-val>=0){
                ans += happiness[i]-val;
            }else{
                ans+=0;
            }

            k--;
            val++;
            i--;
        }

        return ans;

    }
}

//2nd Solution
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int val=0,c=0;

        for(int i=happiness.length-1; i>=happiness.length-k; i--){
            val=happiness[i]-c++;
            if(val>0){
                ans+= val;
            }
        }

        return ans;
    }
}
