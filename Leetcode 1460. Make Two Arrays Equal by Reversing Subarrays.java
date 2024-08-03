//optimised approach
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        int n= arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]!=target[i]) return false;
        }

        return true;
    }
}

//2nd approach
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        var map= new int[1001];

        for(int n: arr) map[n]++;

        for(int n:target) map[n]--;

        return Arrays.equals(map, new int[1001]);
    }
}
