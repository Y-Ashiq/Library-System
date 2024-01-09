import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class DisplayUsers {


    public static void Display() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.txt"));

        ArrayList<User> userList = (ArrayList<User>) ois.readObject();


        if (userList.isEmpty()) {
            System.out.println("No User available.");
        } else {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Users Details");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                String[] columnNames = {"User ID", "Password", "Role"};
                DefaultTableModel model = new DefaultTableModel(null, columnNames);

                for (User user : userList) {
                    Object[] rowData = {user.getUserId(), user.getPassword(), user.getRole()};
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
