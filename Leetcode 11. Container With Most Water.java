class Solution {
    public int maxArea(int[] height) {
        int ans=Integer.MIN_VALUE, water, left=0, right=height.length - 1;
        while(left<= right){
            System.out.print(left+" "+right);
            System.out.println();
            water=Math.min(height[left], height[right])*(right-left);
            ans=Math.max(ans,water);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
