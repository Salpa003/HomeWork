public class MonthData {
    int[] days = new int[30];


   public void printDaysAndStepsFromMonth(){
       for (int i = 0; i < days.length; i++) {
           System.out.println(String.format("День %d : %d",i+1,days[i]));
       }
   }
   public int sumStepsFromMonth(){
       int sum = 0;
       for(int e: days){
           sum += e;
       }
       return sum;
   }
   public int maxSteps(){
       int max = -1;
       for (int e:days){
           if (e>max)
               max=e;
       }
       return max;
   }
   public int bestSeries(int goalByStepsPerDay){
       int maxSeria = 0;
       int seria = 0;
       for (int i = 0; i < days.length; i++) {
           if (days[i]>=goalByStepsPerDay) {
               seria++;
           }
           else {
               if (seria>maxSeria)
                   maxSeria = seria;
               seria = 0;
           }
       }
       return maxSeria;
   }
}
