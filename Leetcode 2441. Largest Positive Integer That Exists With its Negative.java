//two approchaes here 1st with a data structure being used.

class Solution {
    public int findMaxK(int[] nums) {
        int max= Integer.MIN_VALUE;
        Set<Integer> pos= new HashSet<>();
        Set<Integer> neg= new HashSet<>();

        for( int x: nums){
           if(x>0){
            pos.add(x);
            if(neg.contains(x)){
                max= Math.max(max,x);
            }
           }
           else{
            neg.add(Math.abs(x));
            if(pos.contains(Math.abs(x))){
                max=Math.max(max,Math.abs(x));
            }
           }
        }

        return max==Integer.MIN_VALUE? -1: max;

    }
}

//with basic sorting and itration

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=nums.length-1;j>=0;j--)
            {
                if(nums[j]==-nums[i])
                {
                    return nums[j];
                }
            }
        }
        return -1;
    }
}
