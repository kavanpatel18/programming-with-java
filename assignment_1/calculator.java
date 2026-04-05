import java.util.Scanner;

public class calculator {
    public int addNums(int n1, int n2) {
        return n1 + n2;
    }

    public int subNums(int n1, int n2) {
        return n1 - n2;
    }

    public int mulNums(int n1, int n2) {
        return n1 * n2;
    }

    public float divNums(int n1, int n2) {
        return (float) n1 / n2;
    }

    public int calcMod(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {
        calculator c = new calculator();
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nEnter first number: ");
            int n1 = scan.nextInt();

            System.out.println("Enter second number: ");
            int n2 = scan.nextInt();

            System.out.println("\nChoose Operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("0. EXIT");
            System.out.print("Enter operation: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Result: " + c.addNums(n1, n2));
                    break;
                case 2:
                    System.out.println("Result: " + c.subNums(n1, n2));
                    break;
                case 3:
                    System.out.println("Result: " + c.mulNums(n1, n2));
                    break;
                case 4:
                    System.out.println("Result: " + c.divNums(n1, n2));
                    break;
                case 5:
                    System.out.println("Result: " + c.calcMod(n1, n2));
                    break;
                
                default:
                    System.out.println("Invalid option! Try again.");
            }

        } while (op != 0);

        scan.close();
    }
}
