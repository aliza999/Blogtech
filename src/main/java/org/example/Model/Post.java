package org.example.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts") //table name is Post and TechnicalBlog is my db name
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )
    @Column(name ="id")
    private Integer id;

    @Column(name ="title")
    private String title;

    @Column(name ="body")
    private String body;

    @Column(name="date")
    private Date date;

@ManyToOne(fetch=FetchType.EAGER) //many wali side foreign key lagao
@JoinColumn(name="user_id")
private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}




