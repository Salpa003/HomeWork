 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker=new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();

            if (command<=0||command>4){
                System.out.println("~ Такой команды нет ~");
                continue;
            }
           else if (command==1){
                stepTracker.addNewNumberStepsPerDay();
            }
          else   if (command==2){
                stepTracker.changeStepGoal();
            }
          else   if (command==3){
                stepTracker.printStatistic();
            }
           else if (command==4){
               return;
            }
        }//while
    }

    public static void printMenu() {
        System.out.println("Выберите команду ! \n" +
                " 1 -  ввести количество шагов за определённый день;\n" +
                " 2 - изменить цель по количеству шагов в день;\n" +
                " 3 - напечатать статистику за определённый месяц;\n" +
                " 4 - выйти из приложения.");
    }
}