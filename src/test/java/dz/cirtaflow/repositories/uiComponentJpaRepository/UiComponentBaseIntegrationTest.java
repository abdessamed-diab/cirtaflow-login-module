package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.Input;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
/**
 * base class for ui component test.
 * like node, view ..ect
 */
public class UiComponentBaseIntegrationTest extends NodeFactory implements Serializable {
    private static final Logger LOG= LogManager.getLogger(UiComponentBaseIntegrationTest.class);

    /**
     * defining all needed dependencies for ui component.
     */
    @Autowired(required = true)
    protected InputRepository nodeRepository;

    @Autowired(required = true)
    protected ViewRepository viewRepository;

    @Autowired(required = true)
    protected ButtonElementRepository buttonElementRepository;


    /**
     * default constructor, call base class for setting node instance.
     * node domain model represent the very basic input ui needed for building web pages.
     */
    protected UiComponentBaseIntegrationTest() {
        super(Input.class);
        LOG.traceEntry("default constructor.");
    }
}
