class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int l= nums.length;
        if(l<=4){
            return 0;
        }
        
        int ans= Math.min(Math.min(nums[l-1]-nums[3], nums[l-2]- nums[2]),Math.min(nums[l-3]-nums[1], nums[l-4]-nums[0]));
        return ans;
    }
}
