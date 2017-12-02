package dz.cirtaflow.models.cirtaflow;

import org.activiti.engine.identity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person implements User {
    private static final Logger LOG= LogManager.getLogger(Person.class);

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 32, nullable = true)
    private String email;

    @Column(name = "PASSWORD", length = 500, nullable = true)
    private String password;

    @Column(name = "PICTURE_SET", nullable = false)
    private boolean pictureSet= false;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String s) {

    }

    @Override
    public void setLastName(String s) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setEmail(String s) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String s) {

    }

    @Override
    public boolean isPictureSet() {
        return false;
    }
}
