package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PORTAL_USER")
public class PortalUser implements Serializable {
    private int id;
    private String login;
    private String password;
    private String token;
    private String role;

    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "userGenerator", sequenceName = "USER_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenerator")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "USER_LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "USER_PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PortalUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
