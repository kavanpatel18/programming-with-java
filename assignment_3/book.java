public class book {

    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    // Default constructor
    public book() {
        title = "The Silent Patient";
        price = 599;
        ISBN = "XYZ1234";
        genre = "Fiction";
        author = "Alex Michaelides";
    }

    // Constructor with validation for price and genre
    public book(String title, double price, String genre)
            throws InvalidPriceException, InvalidBookGenreException {

        this.title = title;

        // Check for negative price
        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");

        this.price = price;

        // Validate genre
        if (!genre.equals("Fiction") &&
            !genre.equals("Non-fiction") &&
            !genre.equals("Auto-biography"))
            throw new InvalidBookGenreException("Invalid genre");

        this.genre = genre;
    }

    // Full parameterized constructor with validation
    public book(String title, double price, String ISBN,
                String genre, String author)
            throws InvalidPriceException, InvalidBookGenreException {

        this.title = title;

        // Check for negative price
        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");

        this.price = price;
        this.ISBN = ISBN;

        // Validate genre
        if (!genre.equals("Fiction") &&
            !genre.equals("Non-fiction") &&
            !genre.equals("Auto-biography"))
            throw new InvalidBookGenreException("Invalid genre");

        this.genre = genre;
        this.author = author;
    }

    // Copy constructor
    public book(book b) {
        this.title = b.title;
        this.price = b.price;
        this.ISBN = b.ISBN;
        this.genre = b.genre;
        this.author = b.author;
    }

    // Display method to print book details
    public void display() {
        System.out.println("Title: " + title +
                " | Author: " + author +
                " | Genre: " + genre +
                " | ISBN: " + ISBN +
                " | Price: $" + price);
    }
}
