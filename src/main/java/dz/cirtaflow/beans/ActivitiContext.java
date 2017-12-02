package dz.cirtaflow.beans;

import org.activiti.engine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "activitiContext")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ActivitiContext implements DefaultSingletonBeanStructure {
    private static Logger LOG = LogManager.getLogger(ActivitiContext.class);

    @Autowired(required = true)
    @Qualifier("processEngine")
    private ProcessEngine processEngine;

    protected ActivitiContext() {
        LOG.info("default const");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean");

    }

    @Override
    public void destroy() throws Exception {
        LOG.info("destroy bean");
    }

    public RuntimeService getRuntimeService() {
        return this.processEngine.getRuntimeService();
    }

    public RepositoryService getRepositoryService() {
        return this.processEngine.getRepositoryService();
    }

    public FormService getFormService() {
        return this.processEngine.getFormService();
    }

    public TaskService getTaskService() {
        return this.processEngine.getTaskService();
    }

    public HistoryService getHistoryService() {
        return this.processEngine.getHistoryService();
    }

    public IdentityService getIdentityService() {
        return this.processEngine.getIdentityService();
    }

    public ManagementService getManagementService() {
        return this.processEngine.getManagementService();
    }

    public DynamicBpmnService getDynamicBpmnService() {
        return this.processEngine.getDynamicBpmnService();
    }


}
