import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddBook {

    public static void addBook(Scanner scan) throws IOException, ClassNotFoundException {

        File booksDetail = new File("Books.txt");
        ArrayList<Book> bookList;

        // Read existing data from the file
        if (booksDetail.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(booksDetail));
            bookList = (ArrayList<Book>) ois.readObject();
            ois.close();
        } else {
            // If the file doesn't exist, create a new ArrayList
            bookList = new ArrayList<>();
        }

        System.out.print("Book Name: ");
        String bookName = scan.nextLine();

        System.out.print("Writer Name: ");
        String writerName = scan.nextLine();

        System.out.print("Price: ");
        double price = scan.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scan.nextInt();

        int nextBookId = getNextBookId(bookList);

        boolean bookExists = false;

        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                // Update quantity if the book already exists
                book.updateQuantity(book.getQuantity() + quantity);
                bookExists = true;
                System.out.println("Quantity updated successfully!");
                break;
            }
        }

        if (!bookExists) {
            // Add a new book to the list if it doesn't exist
            Book newBook = new Book(nextBookId, bookName, writerName, price, quantity);
            bookList.add(newBook);
            System.out.println("Book added successfully!");
        }

        // Write the updated data back to the file, overwriting its contents
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(booksDetail));
        oos.writeObject(bookList);
        oos.close();
    }

    private static int getNextBookId(ArrayList<Book> bookList) {
        int maxId = 0;
        for (Book book : bookList) {
            if (book.getBookId() > maxId) {
                maxId = book.getBookId();
            }
        }
        return maxId + 1;
    }
}