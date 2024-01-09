import java.io.Serializable;

public class IssueBook implements Serializable {


    int bookId;
    String  userId;


    public IssueBook(int bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }


    public int getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }
}
