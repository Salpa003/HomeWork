import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData ;
    Converter converter ;
    Scanner scanner ;
    int goalByStepsPerDay ;
    public StepTracker(Scanner scanner){
        monthToData = new MonthData[12];
        this.scanner = scanner;
        converter = new Converter();
        goalByStepsPerDay = 10_000;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i]=new MonthData();
        }
    }

   public void addNewNumberStepsPerDay(){

       System.out.println("Введите номер месяца 1-12 !");
        int month = scanner.nextInt();
        if (month < 1 || month > 12){
            System.out.println("~ Неправильно введён номер месяца ~");
            return;
        }

       System.out.println("Введите день 1-30");
        int day = scanner.nextInt();
        if (day < 1 || day > 30){
            System.out.println("~ Неправильно введён день ~");
            return;
        }

       System.out.println("Введите количество шагов !");
        int steps = scanner.nextInt();
        if (steps <= 0){
            System.out.println("~ Количество шагов меньше нуля ~");
            return;
        }

       monthToData[month-1].days[day-1] = steps;
   }

   public void changeStepGoal(){
       System.out.println("Текущая цель "+goalByStepsPerDay+" . Введите новую цель !");
       int newStepGoal = scanner.nextInt();
       if (newStepGoal <= 0){
           System.out.println("Цель не может быть меньше или равна 0");
           return;
       }
       goalByStepsPerDay = newStepGoal;
   }
   public void printStatistic(){
       System.out.println("За какой месяц вы хотите получить статистику 1-12");
       int month = scanner.nextInt();

       if (month < 0 || month > 12){
           System.out.println("~ Неправильно введён номер месяца ~");
           return;
       }
       MonthData md = monthToData[month-1];
       md.printDaysAndStepsFromMonth();
       System.out.println("Общее количество шагов за месяц "+md.sumStepsFromMonth() );
       System.out.println("Максимальное  количество шагов в месяце "+ md.maxSteps() );
       System.out.println("Cреднее количество шагов "+ ((int)(md.sumStepsFromMonth()/30)) );
       System.out.println("Пройденная дистанция (в км) "+ converter.convertToKm(md.sumStepsFromMonth()) );
       System.out.println("Количество сожжённых килокалорий "+ converter.convertStepsToKilocalories(md.sumStepsFromMonth()) );
       System.out.println(String.format("Лучшая серия %d дней",md.bestSeries(goalByStepsPerDay)));

   }
}
