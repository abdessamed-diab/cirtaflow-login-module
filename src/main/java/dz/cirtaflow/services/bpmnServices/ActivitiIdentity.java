package dz.cirtaflow.services.bpmnServices;

import dz.cirtaflow.repositories.bpmnRepository.ActivitiUserRepo;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

public interface ActivitiIdentity extends Serializable {
    Logger LOG = LogManager.getLogger(ActivitiIdentity.class);

    <S extends User> S  createNewUser (@NonNull String userId)
            throws ActivitiUserRepo.IdentityException;

    void                addUserInfo   (@NonNull String userId, @NonNull String key, @NonNull String value)
            throws ActivitiUserRepo.IdentityException;

    String              getUserInfo   (@NonNull String userId, @NonNull String key)
            throws ActivitiUserRepo.IdentityException;

    void                setUserPicture(@NonNull String userId, @NonNull Picture userPicture)
            throws ActivitiUserRepo.IdentityException;

    void                deleteUserInfo(@NonNull String userId, @NonNull String key)
            throws ActivitiUserRepo.IdentityException;

    List<String> getUserInfoKeys(@NonNull String userId)
            throws ActivitiUserRepo.IdentityException;

    <S extends User> S save(S s);

    <S extends User> Iterable<S> save(Iterable<S> iterable);

    User findOne(String s);

    boolean exists(String s);

    Iterable<User> findAll();

    Iterable<User> findAll(Iterable<String> iterable);

    long count();

    void delete(String s);

    void delete(User user);

    void delete(Iterable<? extends User> iterable);

    void deleteAll();

}
