import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Java CLI Calculator!");
        System.out.println("Enter an operation in the format: <number> <operator> <number>");
        System.out.println("Supported operators: +, -, *, /, sin, cos, tan");
        System.out.println("Note: Trigonometric functions expect input in degrees.");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            String[] parts = input.split("\\s+");

            try {
                if (parts.length == 2) {
                    // Trigonometric functions
                    String function = parts[0];
                    double angleDeg = Double.parseDouble(parts[1]);
                    double angleRad = Math.toRadians(angleDeg); // Convert degrees to radians

                    switch (function) {
                        case "sin":
                            System.out.println("sin(" + angleDeg + "°) = " + Math.sin(angleRad));
                            break;
                        case "cos":
                            System.out.println("cos(" + angleDeg + "°) = " + Math.cos(angleRad));
                            break;
                        case "tan":
                            System.out.println("tan(" + angleDeg + "°) = " + Math.tan(angleRad));
                            break;
                        default:
                            System.out.println("Unsupported function. Use sin, cos, or tan.");
                    }

                } else if (parts.length == 3) {
                    // Arithmetic operations
                    double num1 = Double.parseDouble(parts[0]);
                    String operator = parts[1];
                    double num2 = Double.parseDouble(parts[2]);

                    switch (operator) {
                        case "+":
                            System.out.println("Result: " + (num1 + num2));
                            break;
                        case "-":
                            System.out.println("Result: " + (num1 - num2));
                            break;
                        case "*":
                            System.out.println("Result: " + (num1 * num2));
                            break;
                        case "/":
                            if (num2 == 0.0) {
                                System.out.println("Error: Division by zero.");
                            } else {
                                System.out.println("Result: " + (num1 / num2));
                            }
                            break;
                        default:
                            System.out.println("Unsupported operator. Use one of: +, -, *, /");
                    }

                } else {
                    System.out.println("Invalid input format. Please use: <function> <angle> or <number> <operator> <number>");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
            }
        }

        sc.close();
    }
}
