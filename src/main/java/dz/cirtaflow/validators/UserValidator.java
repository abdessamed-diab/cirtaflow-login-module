package dz.cirtaflow.validators;

import dz.cirtaflow.models.act.ActIdUser;
import org.activiti.engine.identity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class UserValidator implements Validator {
    private static final Logger LOG= LogManager.getLogger(UserValidator.class);

    public UserValidator() {
        LOG.debug("default user validator constructor.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(ActIdUser.class) || aClass.isAssignableFrom(User.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        try {
            ActIdUser user = (ActIdUser) o;

            if(user.getFirst().length() < 8) {
                ValidationUtils.rejectIfEmpty(errors,
                        ActIdUser.class.getDeclaredField("first").getName(),
                        "length must be greater than 8 chars.");
                return ;
            }

            if(user.getLast().length() < 8) {
                ValidationUtils.rejectIfEmpty(errors,
                        ActIdUser.class.getDeclaredField("last").getName(),
                        "length must be greater than 8 chars.");
                return ;
            }

            if(StringUtils.isNotBlank(user.getEmail())){
                InternetAddress email= new InternetAddress(user.getEmail());
                email.validate();
                return ;
            }

        } catch(ClassCastException ex) {
            LOG.error(ex);
            errors.reject("can not cast given object to ActIdUser entity", ex.getMessage());
        } catch (NoSuchFieldException ex) {
            LOG.error(ex);
            errors.reject("field do not exists.", ex.getMessage());
        } catch (AddressException ex) {
            LOG.error(ex);
            errors.reject("email address is incorrect.", ex.getMessage());
        }

    }
}
