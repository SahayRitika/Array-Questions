class Solution {
    public double averageWaitingTime(int[][] customers) {
       int row= customers.length;
       //System.out.println(col);
       double startTime=customers[0][0], finishTime=startTime, waitingTime=0;
       for(int[] arr: customers){
        startTime= finishTime== arr[0]? arr[0]: finishTime> arr[0]? finishTime: arr[0];
        //System.out.println(startTime);  
        finishTime= startTime+ arr[1];
        waitingTime+= finishTime- arr[0];
       }

       return waitingTime/row;
    }
}
