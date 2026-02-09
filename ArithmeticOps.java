import java.util.Scanner;

public class ArithmeticOps
{
    public static void main(String[] args) {
        System.out.println("Enter the choice for arithmetic operation: 1. Add \n 2. Subtract \n 3. Multiply \n 4. Divide");
        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        System.out.println("Option = " + op);
        System.out.println("Enter the first number.");
        double a = scan.nextDouble();
        System.out.println("Enter the second number.");
        double b = scan.nextDouble();
        if (b == 0)
        {
            System.out.println("Second number cannot be 0.");
            return;
        }
        switch(op)
        {
            case 1:
                System.out.println("Sum of the two numbers = " + (a+b));
                break;
            case 2:
                System.out.println("Difference of the two numbers = " + (a-b));
                break;
            case 3:
                System.out.println("Product of the two numbers = " + (a*b));
                break;
            case 4:
                System.out.println("Quotient of the two numbers = " + (a/b));
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
        scan.close();
    }
}