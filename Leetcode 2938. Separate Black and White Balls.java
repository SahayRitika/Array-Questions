class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int zero=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                zero++;
            }else if(zero >0){
                ans+= zero;
            }
        }

        return ans;
    }
}

class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int one=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                one++;
            }else if(one >0){
                ans+= one;
            }
        }

        return ans;
    }
}
