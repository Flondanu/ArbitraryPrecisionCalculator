import java.util.Scanner;
import java.math.BigInteger;

public class ArbitraryPrecisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Arbitrary Precision Integer Calculator\nSupported Operations: +, -, *, /, %, ^ (exponentiation), ! (factorial)");
        System.out.println("Enter 'exit' to quit.");

        while (true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String[] tokens = input.split(" ");
                if (tokens.length == 2 && tokens[1].equals("!")) {
                    BigInteger num = new BigInteger(tokens[0]);
                    System.out.println("Result: " + factorial(num));
                } else if (tokens.length == 3) {
                    BigInteger num1 = new BigInteger(tokens[0]);
                    BigInteger num2 = new BigInteger(tokens[2]);
                    String operator = tokens[1];

                    switch (operator) {
                        case "+":
                            System.out.println("Result: " + num1.add(num2));
                            break;
                        case "-":
                            System.out.println("Result: " + num1.subtract(num2));
                            break;
                        case "*":
                            System.out.println("Result: " + num1.multiply(num2));
                            break;
                        case "/":
                            if (num2.equals(BigInteger.ZERO)) {
                                System.out.println("Error: Division by zero.");
                            } else {
                                System.out.println("Result: " + num1.divide(num2));
                            }
                            break;
                        case "%":
                            if (num2.equals(BigInteger.ZERO)) {
                                System.out.println("Error: Modulo by zero.");
                            } else {
                                System.out.println("Result: " + num1.mod(num2));
                            }
                            break;
                        case "^":
                            if (num2.signum() < 0) {
                                System.out.println("Error: Exponentiation with negative exponent not supported.");
                            } else {
                                System.out.println("Result: " + num1.pow(num2.intValue()));
                            }
                            break;
                        default:
                            System.out.println("Error: Unsupported operator.");
                    }
                } else {
                    System.out.println("Error: Invalid input format.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.signum() < 0) {
            throw new ArithmeticException("Factorial of a negative number is not defined.");
        }
        BigInteger result = BigInteger.ONE;
        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return result;
    }
}
