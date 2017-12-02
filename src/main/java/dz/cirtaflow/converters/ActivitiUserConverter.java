package dz.cirtaflow.converters;

import dz.cirtaflow.services.bpmnServices.ActivitiIdentity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;

public final class ActivitiUserConverter implements Serializable {
    private static Logger LOG= LogManager.getLogger(ActivitiUserConverter.class);

    private ActivitiIdentity identity;

    private ActivitiUserConverter() {}
    public ActivitiUserConverter(ActivitiIdentity identity) {this.identity= identity; }

    public org.activiti.engine.identity.User convert(User userDetails) {
        org.activiti.engine.identity.User activitiUser= this.identity.createNewUser(userDetails.getUsername());
        activitiUser.setFirstName(userDetails.getName());
        activitiUser.setLastName(userDetails.getName());
//        identity.saveUser(activitiUser);
//        identity.addUserInfo(activitiUser.getId(), "authorities",
//                StringUtils.join(userDetails.getAuthorities(), ","));

        return activitiUser;
    }
}
