import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<book> alb = new ArrayList<book>();

        try {

            // Using constructor with validation
            book b1 = new book("The Great Escape", 499, "Fiction");
            alb.add(b1);

            // Using default constructor
            book b2 = new book();
            alb.add(b2);

            // Using copy constructor
            book b3 = new book(b2);
            b3.title = "The Hobbit";
            b3.author = "J.R.R. Tolkien";
            alb.add(b3);

            // Using full parameterized constructor
            book b4 = new book("Deep Health", 370, "ABDK223",
                    "Non-fiction", "Dr. A. Kumar");
            alb.add(b4);

            book b5 = new book("Wings of Fire", 549,
                    "ABCD3101", "Auto-biography", "A.P.J. Abdul Kalam");
            alb.add(b5);

            book b6 = new book("Digital Fortress", 999,
                    "NA67ZI", "Fiction", "Dan Brown");
            alb.add(b6);

            // Intentionally creating book with negative price
            book b7 = new book("Invalid Book", -250, "Fiction");
            alb.add(b7);

        }
        catch (InvalidPriceException ip) {
            System.out.println("Invalid Price: " + ip.getMessage());
        }
        catch (InvalidBookGenreException ibg) {
            System.out.println("Invalid Genre: " + ibg.getMessage());
        }

        int totalPrice = 0;
        int[] fictionCount = {0};

        System.out.println("\n------ FICTION BOOKS ------");

        // Printing Fiction books using forEach()
        alb.forEach(b -> {
            if (b.genre.equals("Fiction")) {

                System.out.println("------------------");
                System.out.println("Title: " + b.title);
                System.out.println("Price: ₹" + b.price);
                System.out.println("Author: " + b.author);
                System.out.println("ISBN: " + b.ISBN);
                System.out.println("Genre: " + b.genre);
                System.out.println("------------------");

                fictionCount[0]++;
            }
        });

        System.out.println("Total Fiction books: " + fictionCount[0]);

        int totalBooks = 0;

        // Calculating average price
        for (book b : alb) {
            totalBooks++;
            totalPrice += b.price;
        }

        if (totalBooks > 0) {
            System.out.println("Average price: ₹" + (totalPrice / totalBooks));
        }

        // Display all books in the ArrayList
        System.out.println("\n------ ALL BOOKS ------");

        for (book b : alb) {
            System.out.println("------------------");
            System.out.println("Title: " + b.title);
            System.out.println("Price: ₹" + b.price);
            System.out.println("Author: " + b.author);
            System.out.println("ISBN: " + b.ISBN);
            System.out.println("Genre: " + b.genre);
        }
    }
}
