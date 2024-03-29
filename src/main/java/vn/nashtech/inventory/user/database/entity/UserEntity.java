package vn.nashtech.inventory.user.database.entity;

import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import vn.nashtech.inventory.user.database.model.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
@DynamicUpdate
@Setter
public class UserEntity extends User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return super.getId();}

    @Column(name = "username")
    public String getUsername() {return super.getUsername();}

    @Column(name = "password")
    public String getPassword() {return super.getPassword();}

    @Column(name = "email")
    public String getEmail() {return super.getEmail();}

    @Column(name = "lastName")
    public String getLastName() {return super.getLastName();}

    @Column(name = "firstName")
    public String getFirstName() {return super.getFirstName();}
}
