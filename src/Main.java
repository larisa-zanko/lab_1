//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.BigDecimal;

public class Main {

    // e
    public static double myPow(double x, int y) {
        double result = 1;
        if (y > 0) {
            for (int i = 1; i <= y; i++) {
                result = x;
            }
        }

        else if (y < 0) {
            for (int i = 0; i <= (-y); i++) {
                result /= x;
            }
        } else {
            result = 1;
        }
        return result;
    }

    //Функция через ряд Тейлора
    public static double myFunction(double x, double e) {
        double y = 0;
        double p = -x;
        double k = 1;
        while (Math.abs(p) > e) {
            p = (-x*Math.pow (x,k-1) )/ k;
            y += p;
            k += 1;
        }
        return y;
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {

            System.out.println("Введите x ∈ (-1,+1): ");
            String line = br.readLine();
            double ourNumber = Double.parseDouble(line);
            BigDecimal ourNumber_1 = new BigDecimal(line);

            System.out.println("Введите натуральное число k: ");
            String secondLine = br.readLine();
            int ourDegree = Integer.parseInt(secondLine);
            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);

            // расчёт e для BigDacimal
            BigDecimal ourDegree_1 = new BigDecimal(secondLine);
            BigDecimal first_1= new BigDecimal(-1);
            BigDecimal ten_1= new BigDecimal(10.0);
            ourDegree_1 = ourDegree_1.negate();
            BigDecimal newDegree_1=new BigDecimal(ourDegree_1.doubleValue());
            BigDecimal e_1 =new BigDecimal(1.0);

            for(int i=0; i<=newDegree_1.doubleValue(); i++) {
                e_1.divide(ten_1);
            }

            // установка знвнаков после запятой
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);

            System.out.println("Результат через стандартные функции: ");
            double result = Math.log(1 - ourNumber);
            System.out.println(formatter.format(result));

            System.out.println("Результат через ряд Тейлора: ");
            double myResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myResult));

            System.out.println("Результат с использованием класса BigDecimal: ");
            BigDecimal result_1 = new BigDecimal(ourNumber_1.toString()).multiply(first_1);
            BigDecimal newOurNumber_1=new BigDecimal(1-ourNumber_1.doubleValue());
            result_1=new BigDecimal( Math.log(newOurNumber_1.doubleValue()));
            System.out.println(formatter.format(Math.log(newOurNumber_1.doubleValue())));
        }
        //  проверка ввода
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}