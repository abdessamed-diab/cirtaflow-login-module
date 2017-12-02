package dz.cirtaflow.repositories.bpmnRepository;

import dz.cirtaflow.beans.ActivitiContext;
import dz.cirtaflow.beans.DefaultSingletonBeanStructure;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository(value = "activitiUserRepoImpl")
public class ActivitiUserRepoImpl implements ActivitiUserRepo, DefaultSingletonBeanStructure{
    private static final Logger LOG= LogManager.getLogger(ActivitiUserRepoImpl.class);
    private IdentityService identityService;

    @Autowired(required = true)
    @Qualifier("activitiContext")
    private ActivitiContext activitiContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean as a crud repository");
        this.identityService= this.activitiContext.getIdentityService();
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy bean");
    }

    @Override
    public <S extends User> S createNewUser(@NonNull  String userId) throws IdentityException {
        if(CHECK_USER_ID(userId))
            return (S) this.identityService.newUser(userId);
        return null;
    }

    @Override
    public void addUserInfo(@NonNull  String userId, @NonNull String key, @NonNull String value) throws IdentityException {
        this.identityService.setUserInfo(userId, key, value);
    }

    @Override
    public String getUserInfo(@NonNull  String userId,@NonNull String key) throws IdentityException {
        if (CHECK_USER_ID(userId)) {
            return this.identityService.getUserInfo(userId, key);
        }
        return null;
    }

    @Override
    public void setUserPicture(@NonNull  String userId, @NonNull Picture userPicture) throws IdentityException {
        if(CHECK_USER_ID(userId))
            this.identityService.setUserPicture(userId, userPicture);
    }

    @Override
    public Picture getUserPicture(@NonNull String userId) {
        if(CHECK_USER_ID(userId))
            return this.identityService.getUserPicture(userId);
        return null;
    }

    @Override
    public void deleteUserInfo(@NonNull  String userId, @NonNull String key) throws IdentityException {
        if(CHECK_USER_ID(userId))
            this.identityService.deleteUserInfo(userId, key);
    }

    @Override
    public List<String> getUserInfoKeys(@NonNull  String userId) throws IdentityException {
        if( CHECK_USER_ID(userId))
            this.identityService.getUserInfoKeys(userId);
        return null;
    }

    @Override
    public <S extends User> S saveUser(User user) {
        this.identityService.saveUser(user);
        if(StringUtils.isNotBlank(user.getId()))
            return (S) identityService.createUserQuery().userId(user.getId()).singleResult();
        else
            return (S) identityService.createUserQuery().userFirstName(user.getFirstName())
            .userLastName(user.getLastName())
            .userEmail(user.getEmail())
            .orderByUserEmail().asc().singleResult();

    }

    @Override
    public boolean deleteUserById(@NonNull String userId) {
        if(userExists(userId))
            identityService.deleteUser(userId);

        return true;
    }

    @Override
    public boolean userExists(@NonNull  String userId) {
        return identityService.createUserQuery().userId(userId).list().size() >0;
    }

    @Override
    public void deleteAll() {
        List<User> users= this.identityService.createUserQuery().list();
        for(User user : users) {
            this.identityService.deleteUser(user.getId());
        }
    }

    @Override
    public void saveAll(Iterable<User> users) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user= iterator.next();
            if(!userExists(user.getId()))
                this.identityService.saveUser(user);
        }
    }

    @Override
    public Integer count() {
        return this.identityService.createUserQuery().list().size();
    }
}
