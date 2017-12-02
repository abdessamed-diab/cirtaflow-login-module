package dz.cirtaflow.repositories.eventListeners;

import dz.cirtaflow.models.act.ActIdUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component(value = "userListener")
public class BeforeSave extends AbstractRepositoryEventListener<ActIdUser>{
    private static final Logger LOG= LogManager.getLogger(BeforeSave.class);

    public BeforeSave() {
        LOG.debug("ActIdUser repository event handler constructor.");
    }

    @Override
    protected void onBeforeSave(ActIdUser entity) {
        LOG.info("on before save: "+entity.toString());
    }


}
