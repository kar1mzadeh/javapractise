import java.util.Scanner;
public class arithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1 =scanner.nextInt();
        int num2=scanner.nextInt();
        int sum = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;

        int integerDivision = 0;
        int remainder = 0;
        if (num2 != 0) {
            integerDivision = num1 / num2;
            remainder = num1 % num2;
        } else {
            System.out.println(" Division by zero is impossible .");
        }
        System.out.println( sum);
        System.out.println(  subtraction);
        System.out.println(  multiplication);
        System.out.println(  integerDivision);
        System.out.println(  remainder);
    }
}
