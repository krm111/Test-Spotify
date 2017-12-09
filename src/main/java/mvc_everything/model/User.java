package mvc_everything.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "u_name", length = 64, nullable = false)
    private String username;

    @Column(name = "pass", length = 64, nullable = false)
    private String password;

    @Column(name = "f_name", length = 64, nullable = false)
    private String firstname;

    @Column(name = "l_name", length = 64, nullable = false)
    private String lastname;

    @Column(name = "gender", length = 16, nullable = false)
    private String gender;

    private Date signedInDate;

    private boolean active;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*
    public Date getSignedInDate() {
        return signedInDate;
    }

    public void setSignedInDate(Date signedInDate) {
        this.signedInDate = signedInDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    */

}
