class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int prefix[]= new int[nums.length];

        for(int i=1; i<nums.length; i++){
            if((nums[i]-nums[i-1])%2==0){
                prefix[i]= prefix[i-1]+1;
            }else{
                prefix[i]= prefix[i-1];
            }
        }
        //System.out.println(Arrays.toString(prefix));
        boolean res[]= new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int start= queries[i][0];
            int end= queries[i][1];
            if(prefix[start]== prefix[end]){
                res[i]= true;
            }
        }

        return res;
    }
}
