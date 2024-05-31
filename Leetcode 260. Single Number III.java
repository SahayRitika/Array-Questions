class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }

        int ans[]= new int[2];
        int i=0;
        for(int num: set){
            ans[i++]= num;
        }

        return ans;
    }
}
