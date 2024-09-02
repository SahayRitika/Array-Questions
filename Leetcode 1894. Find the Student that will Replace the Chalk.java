class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        return helper(chalk, k);
    }

    public int helper(int[] chalk, int remains){
        int sum=0;
        for(int i=0; i<chalk.length; i++){
            sum+= chalk[i];
            if(sum> remains){
                return i;
            }
        }

        return helper(chalk, remains%sum);
    }
}
