package dz.cirtaflow.repositories.bpmnJpaRepository;

import dz.cirtaflow.models.act.ActIdUser;
import dz.cirtaflow.repositories.bpmnJPARepository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
public class UserRepositoryTest implements Serializable {
    private static final Logger LOG= LogManager.getLogger(UserRepositoryTest.class);

    private String firstname= "salah";
    private String lastname = "diab";
    private String email= "abdou_gl@live.fr";
    private String password= "Abdessamed178";

    private ActIdUser user;

    @Autowired(required = true)
    private UserRepository userRepository;

    public UserRepositoryTest() {
        LOG.traceEntry();
    }

    @BeforeEach
    public void beforeEach() {
        this.user= new ActIdUser();
        this.user.setId(this.firstname+"."+this.lastname);
        this.user.setFirst(this.firstname);
        this.user.setLast(this.lastname);
        this.user.setEmail(this.email);
        this.user.setPwd(password);

        this.userRepository.save(this.user);
    }

    @AfterEach
    public void afterEach() {
        if(userRepository.existsById(user.getId()))
            this.userRepository.deleteById(this.user.getId());
    }

    @Test
    public void testFindById() {
        Optional<ActIdUser> user= this.userRepository.findById(this.user.getId());
        assumeTrue(user.isPresent(), "assumption field.");
        assertEquals(this.firstname, user.get().getFirst(), "result mismatch.");
    }

    @Test
    public void deleteAll() {
        this.userRepository.deleteAll();
        assertEquals(0, this.userRepository.count(), "result mismatch.");
    }
}
