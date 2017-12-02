package dz.cirtaflow.services.facebookServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public interface FacebookCredentialsHolder extends Serializable{
    Logger LOG= LogManager.getLogger(FacebookCredentialsHolder.class);

    String APP_ID_KEY       = "spring_social_facebook_app_id";
    String APP_SECRET_KEY   = "spring_social_facebook_app_secret";
    String APP_NAMESPACE    = "spring_social_facebook_app_name";

    default File getAppContextConfigFileResource() throws IOException {
        ClassPathResource classpathResource= new ClassPathResource("props.properties");
        return classpathResource.getFile();
    }

    default String getPropertyByName(String propertyName) {
        Properties props= new Properties();
        try {
            props.load(
                    new FileInputStream(    getAppContextConfigFileResource()   )
            );
            return props.getProperty(propertyName);
        } catch (IOException ex) {
            LOG.error(ex);
            return null;
        }
    }

    default String getPropertyIn(final String inValue) {
        Properties props= new Properties();
        try {
            props.load(
                    new FileInputStream(    getAppContextConfigFileResource()   )
            );

            List list = props.entrySet().stream().
                    filter( (Map.Entry entry) -> entry.getKey().toString().toLowerCase().contains(inValue) ).
                    map( (Map.Entry entry) -> entry.getValue()).
                    collect(Collectors.toList());

            return (String) list.get(0);

        } catch (IOException ex) {
            LOG.error(ex);
        }

        return null;
    }

    default String getAppId() {
        return getPropertyByName(APP_ID_KEY);
    }

    default String getAppSecret() {
        return getPropertyByName(APP_SECRET_KEY);
    }

    default String getAppNamespace() {
        return getPropertyByName(APP_NAMESPACE);
    }

}
