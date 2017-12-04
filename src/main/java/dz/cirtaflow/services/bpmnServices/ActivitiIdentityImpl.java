package dz.cirtaflow.services.bpmnServices;

import dz.cirtaflow.beans.DefaultSingletonBeanStructure;
import dz.cirtaflow.repositories.bpmnRepository.ActivitiUserRepo;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("activitiIdentityImpl")
@Transactional("activitiTransactionManager")
public class ActivitiIdentityImpl implements DefaultSingletonBeanStructure, ActivitiIdentity {
    private static Logger LOG = LogManager.getLogger(ActivitiIdentityImpl.class);

    public ActivitiIdentityImpl() {LOG.info("init bean");}

    @Autowired(required = true)
    @Qualifier("activitiUserRepoImpl")
    private ActivitiUserRepo userRepo;

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean");
    }

    @Override
    public <S extends User> S createNewUser(String userId) throws ActivitiUserRepo.IdentityException {
        return (S) userRepo.createNewUser(userId);
    }

    @Override
    public <S extends User> S createAndSaveNewUser(@NonNull String firstName,@NonNull String lastName,@NonNull String email) {
        User user= this.userRepo.createNewUser(firstName+"."+lastName);
        if(userRepo.userExists(user.getId()) )
            return (S) userRepo.findUserById(user.getId()).get();
        if(userRepo.existsByEmail(email) )
            return (S) userRepo.findByEmail(email).get();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(user.getFirstName()+"."+user.getLastName());
        user = this.userRepo.saveUser(user);
        userRepo.addUserInfo(user.getFirstName()+"."+user.getLastName(), "authority", "ROLE_USER");
        return (S) user;
    }

    @Override
    public void addUserInfo(String userId, String key, String value) throws ActivitiUserRepo.IdentityException {
        userRepo.addUserInfo(userId, key, value);
    }

    @Override
    public String getUserInfo(String userId, String key) throws ActivitiUserRepo.IdentityException {
        return userRepo.getUserInfo(userId, key);
    }

    @Override
    public void setUserPicture(String userId, Picture userPicture) throws ActivitiUserRepo.IdentityException {
        userRepo.setUserPicture(userId, userPicture);
    }

    @Override
    public void deleteUserInfo(String userId, String key) throws ActivitiUserRepo.IdentityException {
        userRepo.deleteUserInfo(userId, key);
    }

    @Override
    public List<String> getUserInfoKeys(String userId) throws ActivitiUserRepo.IdentityException {
        return userRepo.getUserInfoKeys(userId);
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAll(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

}
