import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class AddIssue {

    public static void Add(Scanner scan) throws IOException, ClassNotFoundException {


        ObjectInputStream oisB= new ObjectInputStream(new FileInputStream("Books.txt"));
        ArrayList<Book> bookList = (ArrayList<Book>) oisB.readObject();
        oisB.close();

        File issueDetail = new File("Issue.txt");
        ArrayList<IssueBook> issuedBooks ;


        if(issueDetail.exists()){

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(issueDetail));
            issuedBooks = (ArrayList<IssueBook>) ois.readObject();
            ois.close();

        } else {

            issuedBooks= new ArrayList<>();
        }

        System.out.println("Please enter user ID:");
        String userID = scan.nextLine();
        System.out.println("Please enter the book ID:");
        int bookID = scan.nextInt();

        boolean isBookAlreadyIssued = true;

        for (Book book : bookList) {
            if (book.getBookId() == bookID) {
                isBookAlreadyIssued = false;
                break;
            }
        }

        if (isBookAlreadyIssued) {
            System.out.println("Sorry, this book is already issued or not found.");
        } else {
            IssueBook issueBook = new IssueBook(bookID, userID);
            issuedBooks.add(issueBook);

            System.out.println("Book issued successfully.");



            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(issueDetail));
            oos.writeObject(issuedBooks);
            oos.close();
        }
    }
}
