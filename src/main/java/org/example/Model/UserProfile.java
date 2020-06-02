package org.example.Model;

import javax.persistence.*;

@Entity
@Table(name="user_profile")
public class UserProfile

{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="profile_id")
    private Integer id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email_address")
    private String email;
    @Column(name="mobile_no")
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
