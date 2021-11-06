package cn.cqu.edu.domain;
import org.springframework.data.annotation.Id;
public class User {
    @Id
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
     }