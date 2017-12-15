package dz.cirtaflow.models.cirtaflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.social.facebook.api.FacebookObject;
import org.springframework.social.facebook.api.User;
import org.springframework.util.SerializationUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "CF_PROFILE")
@Embeddable
public class Profile extends FacebookObject implements Serializable{
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String gender;
    private Locale locale;
    private List<Profile> friendList;
    private User fcUser;
    private byte[] fcUserAsByteArray;
    private byte[] profilePicture;

    public Profile() {
    }

    public Profile(String id, String name, String firstName, String lastName, String gender, Locale locale) {
        this.id= id;
        this.name= name;
        this.firstName= firstName;
        this.lastName= lastName;
        this.gender= gender;
        this.locale= locale;
    }

    @Id
    @Column(name = "ID", updatable = true, insertable = true, nullable = false, unique = true)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false, insertable = true, updatable = true, name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FIRST_NAME", updatable = true, insertable = true, nullable = false, unique = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(unique = false, nullable = false, insertable = true, updatable = true, name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "GENDER", updatable = true, insertable = true, nullable = false, unique = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(unique = false, nullable = false, insertable = true, updatable = true, name = "LOCALE")
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * we put Embedded annotation just to make sure that hibernate will create for us FKs automatically.
     * @return list of friend profiles.
     */
    @Embedded
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Profile.class)
    public List<Profile> getFriendList() {
        return  friendList;
    }

    public void setFriendList(List<Profile> friendList) {
        this.friendList = friendList;
    }

    /**
     * we dont need to export this field since we already did the conversion.
     * @return byte[] array
     */
    @JsonIgnore
    @Lob
    @Column(unique = true, nullable = true, insertable = true, updatable = true, name = "FC_USER_AS_BYTES", length = Integer.MAX_VALUE)
    public byte[] getFcUserAsByteArray() {
        return fcUserAsByteArray;
    }

    public void setFcUserAsByteArray(byte[] fcUserAsByteArray) {
        this.fcUserAsByteArray = fcUserAsByteArray;
    }

    @Transient
    public User getFcUser() {
        return this.fcUser = (User) SerializationUtils.deserialize(this.fcUserAsByteArray);
    }

    public void setFcUser(User fcUser) {
        this.fcUser = fcUser;
        this.fcUserAsByteArray = SerializationUtils.serialize(fcUser);
    }

    @Lob
    @Column(name = "PROFILE_PICTURE", length = Integer.MAX_VALUE, updatable = true, insertable = true, nullable = true, unique = false)
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
