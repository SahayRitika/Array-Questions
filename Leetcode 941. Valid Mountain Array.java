class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3){
            return false;
        }
        boolean incOrder=false, decOrder= false;
        for(int i=0; i<n-1; i++){
            if(arr[i+1]- arr[i] >=0){
                if(decOrder || arr[i+1]- arr[i]==0)
                return false;
                incOrder= true;
            }else{
                decOrder= true;
            }
        }

        return (incOrder && decOrder);
    }
}
