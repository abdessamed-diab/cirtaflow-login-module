package dz.cirtaflow.web;

import dz.cirtaflow.repositories.uiComponentJpaRepository.projections.InputProjection;
import dz.cirtaflow.validators.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class CustomizedRestMvcConfiguration extends RepositoryRestConfigurerAdapter {
    private static final Logger LOG = LogManager.getLogger(CustomizedRestMvcConfiguration.class);

    public CustomizedRestMvcConfiguration() {
        super();
        LOG.debug("default constructor.");
    }

    /**
     * define the base method that should configurer Spring data rest.
     * @param config Repository rest configuration instance class to configurer Spring data rest module.
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        LOG.debug("configure repository rest configuration.");
        config.setBasePath("/api");
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyForPutAndPost(true);
        config.setReturnBodyOnUpdate(true);
        config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.DEFAULT);
        config.setDefaultMediaType(MediaType.valueOf("application/hal+json"));
        config.setMaxPageSize(20);
        config.setDefaultPageSize(10);


//        attache projections
        config.getProjectionConfiguration().addProjection(InputProjection.class);
    }

    /**
     * attache validators to entities.
     * @param validatingListener of type ValidatingRepositoryEventListener.
     */
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeSave", new UserValidator());
    }



}
