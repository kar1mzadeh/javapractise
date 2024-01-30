public class Month {
    public static void main(String[] args) {
        // Check if there are exactly two command-line arguments
        if (args.length != 2) {
            System.out.println("Please provide two integers as command-line arguments.");
            return;
        }

        // Parse command-line arguments as integers
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        // Perform arithmetic operations
        int sum = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;

        // Avoid division by zero
        int integerDivision = 0;
        int remainder = 0;
        if (num2 != 0) {
            integerDivision = num1 / num2;
            remainder = num1 % num2;
        } else {
            System.out.println("Cannot perform integer division. Division by zero.");
        }

        // Print the results
        System.out.println("Sum: " + sum);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Integer Division: " + integerDivision);
        System.out.println("Remainder: " + remainder);
    }
}
