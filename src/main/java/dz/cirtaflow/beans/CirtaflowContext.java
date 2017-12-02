package dz.cirtaflow.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "cirtaflowContext")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CirtaflowContext implements DefaultSingletonBeanStructure, ApplicationContextAware {
    private static Logger LOG = LogManager.getLogger(CirtaflowContext.class);

    private ApplicationContext springAppCtx;

    protected CirtaflowContext() {
        LOG.info("init bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean");
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springAppCtx = applicationContext;
    }

    public ApplicationContext getSpringAppCtx() {
        return springAppCtx;
    }


}
