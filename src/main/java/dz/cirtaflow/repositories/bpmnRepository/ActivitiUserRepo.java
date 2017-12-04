package dz.cirtaflow.repositories.bpmnRepository;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface ActivitiUserRepo extends Serializable{
    Logger LOG= LogManager.getLogger(ActivitiUserRepo.class);
    byte USERNAME_MAX_LENGTH= 7;

    default boolean CHECK_USER_ID(String idUser) throws IdentityException {
        if (    StringUtils.isBlank(idUser) || idUser.length() <= USERNAME_MAX_LENGTH  )
            throw new IdentityException("user id must not be null.");

        return true;
    }

    final class IdentityException extends ActivitiIllegalArgumentException {
        private String message;

        private IdentityException(String message) {
            super(message);
        }

        private IdentityException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    <S extends User> S  createNewUser (@NonNull String userId)
                                        throws IdentityException;

    void                addUserInfo   (@NonNull String userId, @NonNull String key, @NonNull String value)
                                        throws ActivitiUserRepo.IdentityException;

    String              getUserInfo   (@NonNull String userId, @NonNull String key)
                                        throws IdentityException;

    void                setUserPicture(@NonNull String userId, @NonNull Picture userPicture)
                                        throws IdentityException;

    Picture             getUserPicture(@NonNull String userId);

    void                deleteUserInfo(@NonNull String userId, @NonNull String key)
                                        throws IdentityException;

    List<String>        getUserInfoKeys(@NonNull String userId)
                                        throws IdentityException;

    <S extends User> S   saveUser(@NonNull User user);

    void                saveAll(Iterable<User> users);

    boolean             deleteUserById(@NonNull String userId);

    boolean             userExists(@NonNull String userId) ;

    void                deleteAll();

    Integer                count();

    Iterable<User>      findAll();

    boolean             existsByEmail(@NonNull String email);

    Optional<User> findUserById(String userId);

    Optional<User>      findByEmail(String email);

//    drop table ACT_GE_PROPERTY cascade constraints;
//    drop table ACT_RU_VARIABLE cascade constraints;
//    drop table ACT_GE_BYTEARRAY cascade constraints;
//    drop table ACT_RE_DEPLOYMENT cascade constraints;
//    drop table ACT_RU_IDENTITYLINK cascade constraints;
//    drop table ACT_RU_TASK cascade constraints;
//    drop table ACT_RE_PROCDEF cascade constraints;
//    drop table ACT_RU_EXECUTION cascade constraints;
//    drop table ACT_ID_MEMBERSHIP cascade constraints;
//    drop table ACT_ID_GROUP cascade constraints;
//    drop table ACT_ID_USER cascade constraints;
//    drop table ACT_ID_INFO cascade constraints;
//    drop table ACT_RU_JOB cascade constraints;
//    drop table ACT_HI_PROCINST cascade constraints;
//    drop table ACT_HI_ACTINST cascade constraints;
//    drop table ACT_HI_TASKINST cascade constraints;
//    drop table ACT_HI_DETAIL cascade constraints;
//    drop table ACT_HI_COMMENT cascade constraints;
//    drop table ACT_HI_ATTACHMENT cascade constraints;
//    drop table ACT_RU_EVENT_SUBSCR cascade constraints;

}
