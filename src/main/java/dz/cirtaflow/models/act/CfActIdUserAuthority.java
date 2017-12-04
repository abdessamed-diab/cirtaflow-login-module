package dz.cirtaflow.models.act;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CF_ACT_ID_USER_AUTHORITY")
public class CfActIdUserAuthority implements Serializable{
    private Long id;
    private String  email;
    private String  authority;

    private CfActIdUserAuthority() {

    }

    private CfActIdUserAuthority(@NonNull String authorities) {
        this.authority= authorities;
    }

    public CfActIdUserAuthority(@NonNull String authorities, @NonNull String email) {
        this.authority= authorities;
        this.email= email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "EMAIL", nullable = false, unique = true, insertable = true, updatable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(insertable = true, name = "AUTHORITY", updatable = true, unique = false, nullable = true)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


}
