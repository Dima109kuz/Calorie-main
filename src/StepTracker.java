public class StepTracker {
    MonthData MonthData = new MonthData();
    Converter convert = new Converter();


    int goalAll = 10000;
    MonthData[] monthToData;

    public StepTracker() { //Функция для хранения массива
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveSteps(int monthNum, int dayNum, int steps)
    { //функция записи шагов в массив
        int month = monthNum - 1;  //переменная для значения месяца ( т.к. массив начинается с 0 значения, то от числа пользователя отнимаем 1)
        int day = dayNum - 1; //аналогично с переменной дней
        monthToData[month].days[day] = steps; //заполняем ячейку определенного месяца и дня шагами
        System.out.println("введенное значение = " + steps);
    }

    public void readSteps(int monthNum)
    {
        int month = monthNum - 1;
        int totalSteps = 0;// переменная для вывода всех шагов за месяц
        int Max = 0;// переменная для вывода макимального кол. шагов
        int average = 0; //переменная для определения среднего значения
        for (int i = 0; i < MonthData.days.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month].days[i] + ", ");// вывод массива с шагами за определенный период
        }
        for (int i = 0; i < MonthData.days.length; i++) {
            totalSteps = totalSteps + monthToData[month].days[i]; // подсчет всех шагов за определенный период
            if (Max < monthToData[month].days[i]) {
                Max = monthToData[month].days[i];  // поиск максимального числа шагов за определенный период
            }
        }
        average = totalSteps / MonthData.days.length; // подсчет среднего значения
        System.out.println("Всего шагов за месяц: " + totalSteps);
        System.out.println("Max за месяц: " + Max);
        System.out.println("Среднее количество шагов: " + average);
        convert.convert(totalSteps);


    }

    public int seriesGoal(int goal)
    {
        int newGoal = 0;
        do {
            newGoal = goal;
            System.out.println("Цель изменена. Новое значение цели: " + newGoal);
        }
        while (newGoal < 0);
        {
            goalAll = newGoal;
            return goalAll;
        }
    }
    public void maxSeries(int monthNum) // определение лучшей серии
    {
        int month = monthNum - 1;
        int series = 0;  //переменная а
        int bestSeries = 0; //переменная b
        for (int i = 0; i <  MonthData.days.length; i++) { //создаем цикл длиной в 30 дней
            if (monthToData[month].days[i] > goalAll) { //если значение шагов за i день больше значения "цель", то:
                series = series + 1; //переменная а становится на 1 больше
            } else {
                series = 0; // если значение шагов за день ниже цели, то переменная а обнуляется
            }
            if (bestSeries < series) { //если в следующих днях опять шаги за день становятся больше значения цели, то сравниваем значение переменной b и а
                bestSeries = series;//после приравниваем значение bestSeries с series
            }
        }
            System.out.println("лучшая серия составляет: "+bestSeries+" дня");
    }

}
