import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);




        LoginSession(scan);
        while (true) {
            Menu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    AddBook.addBook(scan);
                    break;
                case 2:
                    DisplayBooks.Display();
                    break;
                case 3:
                    DeleteBook.Delete(scan);
                    break;
                case 4:
                    SearchBook.Search(scan);
                    break;
                case 5:
                    AddUser.Adduser(scan);
                    break;
                case 6:
                    DisplayUsers.Display();
                    break;
                case 7:
                    AddIssue.Add(scan);
                    break;
                case 8:
                    DisplayIssue.Display();
                    break;
                case 9:
                    LoginSession(scan);
                    break;

                case 10:
                    System.out.println(" Goodbye!");
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void LoginSession(Scanner scan) throws IOException, ClassNotFoundException {


        File userDetail = new File("Users.txt");

        System.out.println("please enter the user ID");
        String ID = scan.nextLine();
        scan.nextLine();
        System.out.println("please enter the password");
        String password = scan.nextLine();

        if(userDetail.createNewFile()){



            System.out.println("file created");
        }
        else {


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.txt"));

            ArrayList<User> userList = (ArrayList<User>) ois.readObject();
            for (User user : userList) {

                if ((Objects.equals(ID, "1") && Objects.equals(password, "admin")) || (user.getUserId().equals(ID)  && Objects.equals(user.getPassword(), password) && user.getRole().equals("admin"))) {


                    System.out.println("welcome");
                    return;

                } else {
                    System.out.println("sorry wrong ");
                    //LoginSession(scan, userList);

//                System.exit(0);
                }

            }
        }





    }

    private static void Menu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a book");
        System.out.println("2. Display book details");
        System.out.println("3. Delete Book");
        System.out.println("4. Search Book");
        System.out.println("5. Add User");
        System.out.println("6. Display Users");
        System.out.println("7. issue a book");
        System.out.println("8. display issued books");
        System.out.println("9. logout");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }


}
