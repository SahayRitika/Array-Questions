//Brute Force attempt
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
       int arr[]= new int[n * (n+1) /2];
       int i,j,k,s;
       for(i=0, k=0; i<n;++i){
        s=0;
        for(j=i;j<n;++j){
            s+=nums[j];
            arr[k++]=s;
        }
       }
       
       Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       int ans=0;
       final int mod= (int) 1e9 +7;
       for(i= left-1; i<right; i++){
        ans= (arr[i] +ans) % mod;
       }

       return ans;
    }
}

//Priority Queue Approach

class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int ans = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            int[] p = pq.poll();
            if (i >= left) ans = (ans + p[0]) % mod;
            if (p[1] < n - 1) {
                p[0] += nums[++p[1]];
                pq.offer(p);
            }
        }
        return ans;
    }
}
