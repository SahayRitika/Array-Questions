class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
       Map<Integer, Map<Integer, Integer>> map= new HashMap<>();
       for(int[] arr: pick){
        int player=arr[0];
        int score=arr[1];

        if(!map.containsKey(player)){
            map.put(player, new HashMap<>());
        }

        Map<Integer, Integer> map1= map.get(player);
        map1.put(score, map1.getOrDefault(score, 0)+1);
       }
       
       int winners=0;
       
       for(int i=0; i<n;i++){
        boolean won=false;
        if(map.containsKey(i)){
            Map<Integer, Integer> map1= map.get(i);
            for(int count: map1.values()){
                if(count> i){
                    winners++;
                    won=true;
                }
                if(won)
                break;
            }
        }
       }

       return winners; 
    }
}
