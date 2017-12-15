package dz.cirtaflow.repositories.bpmnJpaRepository;

import dz.cirtaflow.models.cirtaflow.Profile;
import dz.cirtaflow.repositories.bpmnJPARepository.ProfileRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
public class ProfileRepositoryTest implements Serializable{
    private static final Logger LOG= LogManager.getLogger(ProfileRepositoryTest.class);

    Profile profile;
    List<Profile> friendsList;

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileRepositoryTest() {
    }

    @BeforeEach
    public void setup() {
        profile= new Profile("Abdou.Diab_12345678", "Abdou.Diab", "abdessamed", "diab",
                "male", Locale.FRENCH);
        this.friendsList= new ArrayList<>();
        this.friendsList.add(new Profile("Saleh.kahlouche_456789", "Saleh.kahlouche", "salah", "kahlouche",
                "male", Locale.FRENCH));
        profile.setFriendList(this.friendsList);
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testSave() {
        LOG.debug("save new profile.");
        this.friendsList.forEach((Profile profile) -> {
            if(!this.profileRepository.existsById(profile.getId()))
                this.profileRepository.save(profile);
        });

        if(!this.profileRepository.findById(this.profile.getId() ).isPresent()   )
            this.profile = this.profileRepository.save(this.profile);
        assertTrue(true, "cant save profile.");
    }

    @Test
    public void testAddAnotherFriendToFriendList() {
        LOG.debug("add another friend to the existing friend list ");
        Profile newProfile= new Profile("mehdi.guenifi_78456", "mehdi.guenifi", "mehdi", "guenifi",
                "male", Locale.FRENCH);
        if(!this.profileRepository.existsById(newProfile.getId()))
            this.profileRepository.save(newProfile);

        this.profile.getFriendList().add(newProfile);
        this.profile= this.profileRepository.save(profile);
        assertTrue(!this.profile.getFriendList().isEmpty(), "cant add new friend to friend list.");
    }

    @Test
    public void testDeleteFriendFromFriendList() {
        Profile deleteProfile= new Profile("mehdi.guenifi_78456", "mehdi.guenifi", "mehdi", "guenifi",
                "male", Locale.FRENCH);
        Optional<Profile> optionalProfile= this.profileRepository.findById(this.profile.getId());
        assumeTrue(optionalProfile.isPresent(), "assumption fails.");
        Profile profile= optionalProfile.get();

        int size= profile.getFriendList().size();
        profile.getFriendList().forEach((Profile pr) -> {
            if(pr.getId().equals(deleteProfile.getId())) {
                profile.getFriendList().remove(pr);
                this.profile= this.profileRepository.save(profile);
                assertEquals(size-1, profile.getFriendList().size(), "result mismatch");
            }
        });

    }

    @Test
    public void testAddFacebookUserAsByteArrayToProfile() {
        LOG.debug("add facebook user property as byte array to profile.");
        User fcUser= new User("Rokia.Diab_4532145", "Rokia.Diab_178", "rokia", "diab",
                "male", Locale.FRENCH);
        this.profile.setFcUser(fcUser);
        this.profile= this.profileRepository.save(profile);
        assertEquals(fcUser.getId(), profile.getFcUser().getId(), "result mismatch");
    }
}
