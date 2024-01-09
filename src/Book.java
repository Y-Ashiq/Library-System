import java.io.Serializable;

public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String writerName;
    private double price;
    private int quantity;

    public Book(int bookId, String bookName, String writerName, double price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.writerName = writerName;
        this.price = price;
        this.quantity = quantity;
    }


    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
