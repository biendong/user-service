package vn.nashtech.tt.user.database.entity;

import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import vn.nashtech.tt.user.database.model.User;

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
}
