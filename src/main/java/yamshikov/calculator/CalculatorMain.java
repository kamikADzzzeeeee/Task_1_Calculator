package yamshikov.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Основной класс калькулятора
 * @author Ямщиков Д.Ю.
 */
public class CalculatorMain {

    private static final String allOperation = "+ - * /";

    /**
     * Метод для запуска программы
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double num1 = checkNumber(scanner);
        System.out.println("Введите второе число:");
        double num2 = checkNumber(scanner);
        System.out.println("Введите операцию для калькулятора (+, -, /, *):");
        String operation = getOperation(scanner);
        double answer = getAnswer(num1, num2, operation);

        System.out.printf("Ответ:\n%.2f%s%.2f=%.4f", num1, operation, num2,answer);
        //System.out.printf("%4D%s%4D=",num1,num2,operation);

    }

    /**
     * Метод для получения результата из двух цифр и операции между ними
     * @param n1 первая цифра в формате double
     * @param n2 вторая цифра в формате double
     * @param operation операция в строковом виде
     * @return - число в формате double
     */
    private static double getAnswer(double n1, double n2, String operation) {
        double result = 0;
        switch (operation) {
            case ("+"):
                result = n1+n2;
                break;
            case ("-"):
                result = n1-n2;
                break;
            case ("/"):
                try {
                    result = n1 / n2;
                }catch (ArithmeticException exception) {
                    System.out.println("Ошибка при вычислении!");
                }
                break;
            case ("*"):
                result = n1*n2;
                break;
        }
        return result;
    }

    /**
     * Метод для определения и проверки введенного числа в консоль
     * @param scanner на входе объект класса Scanner из которого будут получены данные
     * @return - число в формате double
     */
    private static double checkNumber(Scanner scanner) {
        boolean cycle = true;
        double number = 0;
        while (cycle) {
            cycle = false;
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                cycle = true;
                scanner.next();
                System.out.println("Вы ввели неверный формат числа");
                System.out.println("Введите число еще раз");
            } catch (Exception exception) {
                System.out.println("Неизвестное исключение:");
                System.out.println(exception.getMessage());
            }

        }
        return number;
    }

    /**
     * Метод для определения и проверки введенной операции в консоль
     * @param scanner на входе объект класса Scanner из которого будут получены данные
     * @return - число в формате double
     */
    private static String getOperation(Scanner scanner) {
        boolean cycle = true;
        String operation = "";
        while (cycle) {
            operation = scanner.next();

            for (String op : allOperation.split(" ")) {
                if (op.equals(operation)) {
                    cycle = false;
                    break;
                }
            }

            if (cycle) {
                System.out.println("Вы ввели неверную операцию...");
                System.out.println("Введите операцию еще раз (+, -, /, *):");
            }

        }
        return operation;
    }


}
