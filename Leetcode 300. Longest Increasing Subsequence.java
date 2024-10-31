class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n];
        int ans=1;
        dp[0]=1;
        for(int i=1; i<n; i++){
            int count=0;
            for(int j=i-1; j>=0; j--){
                if(nums[i]> nums[j]) count= Math.max(count, dp[j]);
            }

            dp[i]= count+1;
            ans= Math.max(ans, dp[i]);
        }

        return ans;
    }
}
