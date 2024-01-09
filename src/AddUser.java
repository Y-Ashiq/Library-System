import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddUser {

    public static void Adduser(Scanner scan) throws IOException, ClassNotFoundException {


        File userDetail = new File("Users.txt");
        ArrayList<User> userList ;

        if(userDetail.exists()){

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userDetail));
            userList = (ArrayList<User>)  ois.readObject();
            ois.close();
        }else {
            userList  = new ArrayList<>();


        }






        System.out.println("please enter the user password");
        String password = scan.nextLine();

        System.out.println("please enter the user role (Admin/User)");
        String role = scan.nextLine().toLowerCase();

        String userID = generateDateBasedId();


        User user = new User(userID,password,role);
        userList.add(user);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userDetail));
        oos.writeObject(userList);
        oos.close();




    }
    public static String generateDateBasedId() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHss");
        return now.format(formatter);
    }

}
