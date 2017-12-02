package dz.cirtaflow.services.facebookServices;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.social.facebook.api.TestUser;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import java.util.ArrayList;
import java.util.List;

public class FacebookTemplateSetupTest implements FacebookCredentialsHolder {
    private static final Logger LOG= LogManager.getLogger(FacebookTemplateSetupTest.class);

    protected FacebookTemplate          facebookTemplate= null;
    protected static List<String>       TEST_USER_IDS= new ArrayList<>();



    protected FacebookTemplateSetupTest() {
        LOG.debug("default constructor.");

//        OAuth2Operations OAuth2Operations= new FacebookServiceProvider(getAppId(), getAppSecret(), null).
//                getOAuthOperations();

//        AccessGrant accessGrant= OAuth2Operations.authenticateClient();

        facebookTemplate= new FacebookTemplate(getPropertyIn("access_token"),
                getAppNamespace(), getAppId());

    }


    @BeforeAll
    static void setupTemplate() {
        LOG.info("setup facebook template");

    }

    protected TestUser createTestUser(boolean installed, String permissions, String name) {
        TestUser testUser= facebookTemplate.testUserOperations().createTestUser(installed, permissions, name);
        TEST_USER_IDS.add(testUser.getId());
        return testUser;
    }

    @AfterAll
    static void TearDown() {
        LOG.debug("tear down.");
    }

}
