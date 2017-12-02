package dz.cirtaflow.services.bpmnServices;

import dz.cirtaflow.beans.ActivitiContext;
import dz.cirtaflow.beans.DefaultSingletonBeanStructure;
import org.activiti.engine.RuntimeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("activitiRuntimeImpl")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ActivitiRuntimeImpl implements DefaultSingletonBeanStructure {
    private static Logger LOG = LogManager.getLogger(ActivitiRuntimeImpl.class);

    @Autowired(required = true)
    @Qualifier("activitiContext")
    private ActivitiContext activitiContext;

    private RuntimeService runtimeService;

    protected ActivitiRuntimeImpl() {
        LOG.info("default constructor.");
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.runtimeService = activitiContext.getRuntimeService();
    }
}
