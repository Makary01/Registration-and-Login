package model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Boolean isAdmin;

    public User(String name, String email, String password, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
