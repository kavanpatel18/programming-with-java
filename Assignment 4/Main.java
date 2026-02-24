import java.util.Scanner;

public class Main {

    public static Vector createVector(Scanner sc) throws VectorException {

        System.out.print("Enter dimension (2 or 3): ");
        int dim = sc.nextInt();

        if (dim != 2 && dim != 3) {
            throw new VectorException("Only 2D and 3D vectors are allowed.");
        }

        double[] arr = new double[dim];

        System.out.println("Enter " + dim + " components:");

        for (int i = 0; i < dim; i++) {
            arr[i] = sc.nextDouble();
        }

        return new Vector(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Create Vector 1");
            Vector v1 = createVector(sc);

            System.out.println("Create Vector 2");
            Vector v2 = createVector(sc);

            if (v1.getDimension() != v2.getDimension()) {
                throw new VectorException("Both vectors must have same dimensions.");
            }

            int choice;

            do {
                System.out.println("\nChoose Operation:");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Dot Product");
                System.out.println("4. Exit");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        Vector sum = v1.add(v2);
                        System.out.print("Result: ");
                        sum.printVector();
                        break;

                    case 2:
                        Vector diff = v1.subtract(v2);
                        System.out.print("Result: ");
                        diff.printVector();
                        break;

                    case 3:
                        double dot = v1.dotProduct(v2);
                        System.out.println("Dot Product: " + dot);
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 4);

        } catch (VectorException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}