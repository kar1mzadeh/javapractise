public class Month {
    public static void main(String[] args) {
        // Check if there are exactly two command-line arguments
        if (args.length != 2) {
            System.out.println("Please provide two integers as command-line arguments.");
            return;
        }

        // Parse command-line arguments as integers
        int num1 = Integer.parseInt(args[0]);
        int alaq = Integer.parseInt(args[1]);

        // Perform arithmetic operations
        int sum = num1 + alaq;
        int subtraction = num1 - alaq;
        int multiplication = num1 * alaq;

        // Avoid division by zero
        int integerDivision = 0;
        int remainder = 0;
        if (alaq != 0) {
            integerDivision = num1 / alaq;
            remainder = num1 % alaq;
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
