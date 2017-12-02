package dz.cirtaflow.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

public class DefaultSingletonBean implements Serializable, InitializingBean, DisposableBean {
    private static Logger LOG = LogManager.getLogger(DefaultSingletonBean.class);

    protected DefaultSingletonBean() {

    }

    public void destroy() throws Exception {
        LOG.info("destroy bean.");
    }

    public void afterPropertiesSet() throws Exception {
        LOG.info("after properties set.");
    }


}
