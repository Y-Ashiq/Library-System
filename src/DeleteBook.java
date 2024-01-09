import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBook {
    public static void Delete(Scanner scan) throws IOException, ClassNotFoundException {

        File bookDetail = new File("Books.txt");
        ArrayList<Book> bookList ;


        if(bookDetail.exists()){

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Books.txt"));
            bookList = (ArrayList<Book>) ois.readObject();
            ois.close();

        }else {

            bookList=new ArrayList<>();
        }





        if(bookList.isEmpty()){


            System.out.println("the library is empty");
            return;
        }


        System.out.print("please enter the book ID");

        int bookID = scan.nextInt();
        boolean bookFound = false;


        for (Book book : bookList) {
            if (bookID == book.getBookId()) {
                if (book.getQuantity() > 1) {

                    book.updateQuantity(book.getQuantity() - 1);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookDetail));
                    oos.writeObject(bookList);
                    oos.close();
                } else {

                    bookList.remove(book);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookDetail));
                    oos.writeObject(bookList);
                    oos.close();
                    System.out.println("Book deleted successfully!");
                }
                bookFound = true;
                break;


            }

        }

        if (!bookFound) {


            System.out.println("the book is not found");
        }


    }
}
