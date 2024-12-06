class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set= new HashSet<>();
        for(int num: banned){
            set.add(num);
        }
        int currSum=0, count=0;
        for(int i=1; i<=n; i++){
            if(set.contains(i)){
                continue;
            }

            currSum+= i;

            if(currSum >maxSum){
                break;
            }
            count++;
        }

        return count;
    }
}
