import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker steptrack = new StepTracker();


        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("Введите месяц (от 1 до 12)");
                int monthNum = scanner.nextInt();
                if (monthNum < 1 || monthNum > 12) {
                    System.out.println("Вы ввели неверное число");
                    continue;
                }
                else {
                    System.out.println("Введите число");
                }
                int dayNum = scanner.nextInt();
                if (dayNum<1||dayNum>30) {
                    System.out.println("Вы ввели неверное число");
                    continue;
                }
                else {
                    System.out.println("Введите шаги");
                }
                int steps = scanner.nextInt();
                if (steps<0) {
                    System.out.println("Вы ввели неверное число");
                    continue;
                }
                else
                    steptrack.saveSteps(monthNum, dayNum, steps);
                }
                else if (userInput==2) {
                System.out.println("Печать статистики. Введите месяц (от 1 до 12)");
                int monthNum = scanner.nextInt();
                if (monthNum < 1 || monthNum > 12) {
                    System.out.println("Вы ввели неверное число");
                    continue;
                } else
                    steptrack.readSteps(monthNum);
                steptrack.maxSeries(monthNum);

            }
            else if (userInput==3) {
                System.out.println("Введите значение цели по количеству шагов в день.");
                int goal = scanner.nextInt();
                if (goal < 0) {
                    System.out.println("Цель не может быть отрицательная.");
                    continue;
                } else
                    steptrack.seriesGoal(goal);
                }
                else {
                    System.out.println("Такой команды нет");
                }


                printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                userInput = scanner.nextInt(); // повторное считывание данных от пользователя
            }
            System.out.println("Программа завершена");
        }
    private static void printMenu()
    {
        System.out.println("1 - Введите количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}