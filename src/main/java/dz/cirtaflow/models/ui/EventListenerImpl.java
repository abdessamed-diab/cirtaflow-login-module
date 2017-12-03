package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import java.io.Serializable;

public class EventListenerImpl implements Serializable, EventListener {
    private static final Logger LOG= LogManager.getLogger(EventListenerImpl.class);

    private Event event;
    private Input node;

    protected EventListenerImpl() {
        LOG.debug("default constructor");
    }

    public EventListenerImpl(Input node) {
        LOG.debug("init constructor.");
    }

    @Override
    public void handleEvent(Event event) {
        this.event= event;
        node.getEvents().put(event.getType(), this);
    }
}
