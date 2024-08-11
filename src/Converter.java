public class Converter {
   public int convertToKm(int steps){
        return (int)Math.round((steps*75/100)/1000);
    }
   public int convertStepsToKilocalories(int steps){
       return (int) Math.round(steps* (0.05));
   }
}
