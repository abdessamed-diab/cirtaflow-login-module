package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.Node;
import dz.cirtaflow.models.ui.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class NodeRepositoryTest extends UiComponentBaseIntegrationTest {
    private static final Logger LOG= LogManager.getLogger(NodeRepositoryTest.class);

    /**
     * enable constructor visibility for maven surefire plugin.
     * surefire looks for public constructors for launching unit tests at the build time.
     * you can disable unit tests from running at the build time, by setting skip test to true.
     */
    public NodeRepositoryTest() {
        LOG.debug("default constructor.");
    }

    /**
     * before each test, it should run this method first.
     * test save method goes here.
     */
    @BeforeEach
    public void beforeEach() {
        if(!this.viewRepository.existsByName(VIEW_NAME))
            this.view= this.viewRepository.save(this.view);
        else
            this.view= this.viewRepository.findByName(VIEW_NAME).get();

        this.node.setViewId(this.view);
        this.node= this.nodeRepository.save(this.node);
    }


    /**
     * after each test finished, it should run this method.
     * delete by id method goes here
     */
    @AfterEach
    public void afterEach(){
        if(this.nodeRepository.existsById(this.node.getPk()))
            this.nodeRepository.deleteById(this.node.getPk());
    }


    /**
     * test saving multiple nodes.
     * in this test case, we have a list with five nodes, share the same id value.
     */
    @Test
    public void testSaveAll() {
        LOG.debug("save all inputs.");

        Iterable<? extends Node> list= this.nodeRepository.saveAll(nodes);
        list.forEach((node) -> {
            LOG.info("node: "+node.toString());
            assertNotNull(node.getPk(), "service did not save all rows.");
        });
    }


    /**
     * find by id test method
     * you should see first beforeEach method.
     */
    @Test
    public void testFindById() {
        LOG.debug("find by id.");
        Optional<Node> optionalNode= this.nodeRepository.findById(this.node.getPk());
        assumeTrue(optionalNode.isPresent(), "assumption field.");
        assertEquals(this.node.getPk(), optionalNode.get().getPk(), "find by id did not pass.");
        LOG.info("find by id: "+this.node.getPk()+" equal to "+optionalNode.get().getPk());
    }

    /**
     * exist by id test method.
     * see if the given created node exist.
     */
    @Test
    public void testExistsById() {
        LOG.debug("find by id.");
        assertTrue(     this.nodeRepository.existsById(this.node.getPk()),
                "exist by id did not pass."
        );
    }

    @Test
    public void testFindAll() {
        LOG.debug("find all");
        Iterable<Node> nodes= this.nodeRepository.findAll();
        assertTrue(nodes.iterator().hasNext(), "find all did not pass.");
    }

    @Test
    public void testFindAllById() {
        LOG.debug("find all by id");
        Iterable<Node> nodes= this.nodeRepository.findAll();
        List<Long> ids= new ArrayList<>();
        nodes.forEach((Node node) -> {
            ids.add(node.getPk());
        });
        assertTrue( this.nodeRepository.findAllById(ids).iterator().hasNext(), "find all by id did not pass." );
    }

    /**
     * count records or rows.
     */
    @Test
    public void testCount() {
        LOG.debug("count inputs.");
        assertTrue(this.nodeRepository.count() > 0, "count did not pass.");
    }

    @Test
    public void testDeleteAll() {
        LOG.debug("delete all inputs");
        this.nodeRepository.deleteAll();
        assertFalse(this.nodeRepository.findAll().iterator().hasNext(), "delete all did not pass.");
    }


    @Test
    public void testFindByViewId() {
        Optional<View> latestView= this.viewRepository.findByName(VIEW_NAME);
        assumeTrue(latestView.isPresent(), "view table is empty. assumption field");
        Iterable<Node> nodes= this.nodeRepository.findByViewId(latestView.get());
        assertNotNull(nodes, "find by view id did not pass.");
    }



}
