package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class UserLoginData {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer userId;

    @Column
    private Boolean loginname;

    @Column
    private Boolean passwordhash;

    @Column
    private Boolean passwordsalt;

    @Column
    private Integer hashalgoritmid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public Boolean getLoginname() {
        return loginname;
    }

    public void setLoginname(final Boolean loginname) {
        this.loginname = loginname;
    }

    public Boolean getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(final Boolean passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Boolean getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(final Boolean passwordsalt) {
        this.passwordsalt = passwordsalt;
    }

    public Integer getHashalgoritmid() {
        return hashalgoritmid;
    }

    public void setHashalgoritmid(final Integer hashalgoritmid) {
        this.hashalgoritmid = hashalgoritmid;
    }

}
