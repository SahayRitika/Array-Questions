class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       // Dictionary to store the first occurrence of each remainder
        Map<Integer, Integer> remainderDict = new HashMap<>();
        remainderDict.put(0, -1);  // Edge case for when the subarray starts from index 0
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum % k;
            
            // Handle negative remainders to ensure valid results
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderDict.containsKey(remainder)) {
                if (i - remainderDict.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remainderDict.put(remainder, i);
            }
        }

        return false; 
    }
}
