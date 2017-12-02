package dz.cirtaflow.services.bpmnServices;

import dz.cirtaflow.beans.ActivitiContext;
import dz.cirtaflow.beans.DefaultSingletonBeanStructure;
import org.activiti.engine.RepositoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("activitiRepositoryImpl")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ActivitiRepositoryImpl implements DefaultSingletonBeanStructure {
    private static Logger LOG = LogManager.getLogger(ActivitiRepositoryImpl.class);

    @Autowired(required = true)
    @Qualifier("activitiContext")
    private ActivitiContext activitiContext;

    private RepositoryService repositoryService;

    protected ActivitiRepositoryImpl() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.repositoryService = activitiContext.getRepositoryService();
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy bean");
    }
}
