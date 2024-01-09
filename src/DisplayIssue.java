import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class DisplayIssue {


    public static void Display() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Issue.txt"));

        ArrayList<IssueBook> issuedBooks = (ArrayList<IssueBook>) ois.readObject();


        if (issuedBooks.isEmpty()) {
            System.out.println("No issued books available here.");
        } else {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Book Details");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                String[] columnNames = {"Book ID", "user Name"};
                DefaultTableModel model = new DefaultTableModel(null, columnNames);

                for (IssueBook book : issuedBooks) {
                    Object[] rowData = {book.getBookId(), book.getUserId()};
                    model.addRow(rowData);
                }

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane, BorderLayout.CENTER);

                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }
}

}
