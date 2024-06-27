class Solution {
    public int heightChecker(int[] heights) {
      int[] expected= new int[heights.length];
      expected= Arrays.copyOf(heights, heights.length);
      Arrays.sort(expected);

      int ans=0;
      for(int i=0; i<heights.length; i++){
        if(heights[i] !=expected[i]){
            ans++;
        }
      }

      return ans; 
    }
}
