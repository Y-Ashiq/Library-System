import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchBook {

    public static void Search(Scanner scan) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Books.txt"));

        ArrayList<Book> bookList = (ArrayList<Book>) ois.readObject();
        System.out.println("Please enter the book name or writer name ");
        String search = scan.nextLine();
        boolean found = false;



        for (Book book : bookList) {


//            String result = (book.getBookName().equalsIgnoreCase(search) || book.getWriterName().equalsIgnoreCase(search)) ? "the book exist and here the details" : "the book not found";

            if (book.getBookName().toLowerCase().contains(search.toLowerCase()) || book.getWriterName().toLowerCase().contains(search.toLowerCase())){


                System.out.println("the book exist end here the details :");

                System.out.println("book ID: "+book.getBookId());
                System.out.println("book name: "+book.getBookName());
                System.out.println( "writer name: "+book.getWriterName());
                System.out.println( "price: $"+book.getPrice());
                System.out.println( "Quantity: "+book.getQuantity());
                found = true;


            }



        }
        if(!found) {

            System.out.println("the book or the writer not found");

        }


    }
}
