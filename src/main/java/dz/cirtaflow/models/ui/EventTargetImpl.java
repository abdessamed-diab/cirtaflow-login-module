package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventException;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

import java.io.Serializable;

public class EventTargetImpl implements EventTarget, Serializable {
    private static final Logger LOG= LogManager.getLogger(EventTargetImpl.class);

    private String eventType;
    private EventListener eventListener;
    private Node node;

    private EventTargetImpl(){

    }

    public EventTargetImpl(String eventType) {
        this.eventType= eventType;
    }

    public EventTargetImpl(String eventType, EventListener eventListener) {
        this(eventType);
        this.eventListener= eventListener;
    }

    public EventTargetImpl(String eventType, EventListener eventListener, Node node) {
        this(eventType, eventListener);
        this.node= node;
        node.getEvents().put(eventType, eventListener);
    }

    @Override
    public void addEventListener(String eventType, EventListener eventListener, boolean b) {
        node.getEvents().put(eventType, eventListener);
    }

    @Override
    public void removeEventListener(String eventType, EventListener eventListener, boolean b) {
        LOG.info("******** remove event listener *********");
        node.getEvents().forEach( (type, listener) -> {
            LOG.debug("event type: "+type);
            LOG.debug("event listener: "+listener.toString());
            if(type.equals(eventType)){
                node.getEvents().remove(type);
                LOG.info("event listener is removed.");
            }
        });
    }

    @Override
    public boolean dispatchEvent(Event event) throws EventException {
        LOG.info("********** dispatch event *********");
        LOG.debug("********** looking for requested event: "+event.getType()+" *************");
        boolean isDispatched= false;
        this.node.getEvents().forEach((type, listener) -> {
            LOG.debug("event type: "+type);
            if(type.equals(event.getType())) {
                this.node.getEvents().get(type).handleEvent(event);
                LOG.info("event is dispatched.");
            }
        });

        return isDispatched;
    }
}
