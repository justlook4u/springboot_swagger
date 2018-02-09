package entity;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ma Xiao Dong
 * @Date 2018/2/7
 * @Time 17:57
 * @Purpose
 */
public class User {
    private Long userId;

    private String username;

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}