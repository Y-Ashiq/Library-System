import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
public class DisplayBooks {

    public static void Display() throws IOException, ClassNotFoundException {


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Books.txt"));

        ArrayList<Book> bookList = (ArrayList<Book>) ois.readObject();




        if (bookList.isEmpty()) {
            System.out.println("No books available.");
        } else {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Book Details");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                JScrollPane scrollPane = getjScrollPane(bookList);
                frame.add(scrollPane, BorderLayout.CENTER);

                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }



    }

    private static JScrollPane getjScrollPane(ArrayList<Book> bookList) {
        String[] columnNames = {"Book ID", "Book Name", "Writer Name", "Price", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);

        for (Book book : bookList) {
            Object[] rowData = {book.getBookId(), book.getBookName(), book.getWriterName(),
                    book.getPrice(), book.getQuantity()};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

}
















//        if (bookList.isEmpty()) {
//
//            System.out.println("the library is empty");
//            return;
//        }
//        System.out.print("Book ID                " );
//        System.out.print("Book Name                " );
//        System.out.print("Writer Name                " );
//        System.out.print("Price                " );
//        System.out.print("Quantity                " );
//        System.out.println();
//
//        for (Book book : bookList) {
//
//
//
//            System.out.print(book.getBookId());
//            System.out.print("                       "+book.getBookName());
//            System.out.print( "                       "+book.getWriterName());
//            System.out.print( "                       $"+book.getPrice());
//            System.out.print( "                       "+book.getQuantity());
//
//
//
//            System.out.println();
//        }
