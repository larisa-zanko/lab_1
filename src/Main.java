//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Main {

    // Возводит x в степень y
    public static double myPow(double x, int y) {
        double result = 1;
        for (int i = 0; i < Math.abs(y); i++) {
            result *= x;
        }
        return (y < 0) ? 1 / result : result;
    }

    // Вычисление ln(1 - x) через ряд Тейлора
    public static double myFunction(double x, double e) {
        double y = 0;
        double term = -x; // Первый член ряда
        int k = 1;

        // Суммируем члены ряда до достижения заданной точности e
        while (Math.abs(term) > e) {
            y += term;
            term *= -x / k; // Обновляем член для следующей итерации
            k++;
        }
        return y;
    }

    // Вычисление cos(x) через ряд Тейлора
    public static double myCos(double x, double e) {
        double y = 0;
        double term = 1; // Первый член ряда
        int k = 0;

        // Суммируем члены ряда до достижения заданной точности e
        while (Math.abs(term) > e) {
            y += term;
            k++;
            term *= -x * x / ((2 * k) * (2 * k - 1)); // Обновляем член для следующей итерации
        }
        return y;
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1, +1): ");
            String line = br.readLine();
            double ourNumber = Double.parseDouble(line);
            BigDecimal ourNumber_1 = new BigDecimal(line);

            System.out.println("Введите натуральное число k: ");
            String secondLine = br.readLine();
            int ourDegree = Integer.parseInt(secondLine);
            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);

            // Форматирование вывода
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);

            // Стандартное вычисление логарифма
            System.out.println("Результат через стандартные функции (ln(1 - x)): ");
            double lnResult = Math.log(1 - ourNumber);
            System.out.println(formatter.format(lnResult));

            // Результат через ряд Тейлора для ln(1 - x)
            System.out.println("Результат через ряд Тейлора (ln(1 - x)): ");
            double myLnResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myLnResult));

            // Результат через ряд Тейлора для cos(x)
            System.out.println("Результат через ряд Тейлора (cos(x)): ");
            double myCosResult = myCos(ourNumber, e);
            System.out.println(formatter.format(myCosResult));

            // Сумма результатов
            double sumResult = myLnResult + myCosResult;
            System.out.println("Сумма результатов (ln(1 - x) + cos(x)): ");
            System.out.println(formatter.format(sumResult));

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры.");
        }
    }
}