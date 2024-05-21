class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans= new LinkedList<>();
      List<Integer> list= new LinkedList<>();
      solve(nums, 0, list, ans);

      return ans;
    }

    public void solve(int nums[], int start, List<Integer> list, List<List<Integer>> ans){
        if(nums.length == start){
            ans.add(new LinkedList<>(list));
            return;
        }

        solve(nums, start+1, list, ans);
        list.add(nums[start]);
        solve(nums, start+1, list, ans);
        list.remove(list.size()-1);
    }
}
