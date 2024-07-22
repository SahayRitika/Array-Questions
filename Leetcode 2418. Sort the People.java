class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=heights.length, i,j, temp;
        String temp1;
        boolean swapped;
        for(i=0; i<n-1; i++){
            swapped= false;
            for(j=0; j<n-1-i; j++){
                if(heights[j]< heights[j+1]){
                    temp= heights[j];
                    heights[j] = heights[j+1];
                    heights[j+1] = temp;

                    temp1= names[j];
                    names[j]= names[j+1];
                    names[j+1]= temp1;

                    swapped= true;
                }
            }

            if(swapped == false)
            break;
        }

        return names;
    }
}
