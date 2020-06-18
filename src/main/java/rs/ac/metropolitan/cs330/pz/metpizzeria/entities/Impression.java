package rs.ac.metropolitan.cs330.pz.metpizzeria.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "impression")
public class Impression {

    @Id
    @Column(name = "impression_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impression_id;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;



    public Long getImpression_id() {
        return impression_id;
    }

    public void setImpression_id(Long impression_id) {
        this.impression_id = impression_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Impression{" +
                "impression_id=" + impression_id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
