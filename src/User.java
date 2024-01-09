import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
public class User implements Serializable {



    private String userId;
    private String password;
    private String role;


    public User(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
