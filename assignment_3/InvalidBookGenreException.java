// User defined exception for invalid genre
public class InvalidBookGenreException extends Exception {
    public InvalidBookGenreException(String message) {
        super(message);
    }
}
