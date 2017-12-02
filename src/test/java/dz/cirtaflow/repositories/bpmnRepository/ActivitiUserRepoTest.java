package dz.cirtaflow.repositories.bpmnRepository;

import org.activiti.engine.identity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
public class ActivitiUserRepoTest implements Serializable {
    private static final Logger LOG= LogManager.getLogger(ActivitiUserRepoTest.class);

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String pwd;

    private User user;

    @Autowired(required = true)
    @Qualifier("activitiUserRepoImpl")
    private ActivitiUserRepo userRepo;

    public ActivitiUserRepoTest() {

    }

    @BeforeEach
    public void beforeEach() {
        this.firstname="abedssamed";
        this.lastname= "diab";
        this.email= "abdou_gl@live.fr";
        this.pwd="Abdessamed178";
        this.username= this.firstname+"."+this.lastname;
        user= userRepo.createNewUser(this.username);
    }

    @AfterEach
    public void afterEach() {
        if(userRepo.userExists(this.user.getId()))
            userRepo.deleteUserById(this.user.getId());
    }

    @Test
    public void testSave() {
        this.user= userRepo.saveUser(user);
    }

    @Test
    public void testUserExists() {
        Boolean value= Boolean.valueOf(userRepo.userExists(this.user.getId())   );
        assertNotNull(value, "user exists result not found.");
    }

    @Test
    public void testDeleteById() {
        this.userRepo.deleteUserById(this.user.getId());
    }


    /**
     * do not forget to call create user before saving new user to the data base.
     */
    @Test
    public void testSaveAll() {
        User user= this.userRepo.createNewUser("jamel.amir");
        User user2= this.userRepo.createNewUser("salim.nabile");
        User user3= this.userRepo.createNewUser("nasima.aiachi");

        user.setFirstName("jamel"); user.setLastName("amir");
        List<User> users= new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        this.userRepo.saveAll(users);
    }

    @Test
    public void testDeleteAll() {
        this.userRepo.deleteAll();
        assertEquals(Integer.valueOf(0), this.userRepo.count(), "result mismatch");
    }
}
