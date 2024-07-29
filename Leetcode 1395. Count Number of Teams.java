class Solution {
    public int numTeams(int[] rating) {
        int totalTeams=0, soldierCount=rating.length;

        for(int currentSoldier=0; currentSoldier<soldierCount; currentSoldier++){
            totalTeams+= countTeams(rating, currentSoldier, soldierCount);
        }

        return totalTeams;
    }

    public int countTeams(int[] rating, int currentSoldier, int soldierCount){
        int[] leftCount= countFunc(rating, 0, currentSoldier, rating[currentSoldier]);
        int[] rightCount= countFunc(rating, currentSoldier+1, soldierCount, rating[currentSoldier]);

        int ascTeams= leftCount[0]* rightCount[1];
        int descTeams= leftCount[1]* rightCount[0];

        return ascTeams+ descTeams;
    }

    public int[] countFunc(int[] rating, int start, int end, int refernce){

        int smaller=0, larger=0;
        while(start<end){
            if(rating[start]< refernce){
                smaller++;
            }else if(rating[start]> refernce){
                larger++;
            }
            start++;
        }

        return new int[]{smaller, larger};
    }
}
