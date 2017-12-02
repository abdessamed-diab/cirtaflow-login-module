package dz.cirtaflow.services.facebookServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.social.facebook.api.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath*:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
class SocialFacebookTest extends FacebookTemplateSetupTest {
    private static final Logger LOG= LogManager.getLogger(SocialFacebookTest.class);

    protected TestUser testUser= null;

    SocialFacebookTest() {
        super();
        LOG.info("default test constructor.");
    }

    @BeforeEach
    void setup() {
        LOG.debug("setup test class.");
    }


    @Test
    void testGetUserEmail() {
        LOG.info("get user email.");
        assumeTrue(facebookTemplate != null, "facebook template must not be null");
        assertEquals("rafik_wwygnoo_merabet@tfbnw.net",
                facebookTemplate.userOperations().getUserProfile().getEmail(),
                "email address mismatch.");
    }

    @Test
    void testGetUserAboutMe() {
        LOG.info("get user about me.");
        String aboutYou= null;
        assertNotNull(aboutYou= facebookTemplate.userOperations().getUserProfile().getAbout(),
                "about me should not be null");
        LOG.info("about you: "+aboutYou);
    }

    @Test
    void testGetDateBirthday() {
        LOG.info("get user birthday");
        String strDateBirthday= null;
        assertNotNull(strDateBirthday= facebookTemplate.userOperations().getUserProfile().getBirthday(),
                "date of birthday should not be null.");

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateBirthday= LocalDate.parse(strDateBirthday, formatter);

        assertEquals(2, dateBirthday.getDayOfMonth(),
                "incorrect conversion between facebook date and cirtaflow ");
        LOG.info("date of birthday: "+dateBirthday);
    }

    @Test
    void testGetName () {
        LOG.info("get first name and last name.");
        String firstName= facebookTemplate.userOperations().getUserProfile().getFirstName();
        String lastName= facebookTemplate.userOperations().getUserProfile().getLastName();
        assumeTrue(firstName != null || lastName != null , "can't get first or last name.");
        assertEquals("rafik", firstName, "first name mismatch.");
    }

    @Test
    void testGetCoverPhoto() {
        LOG.info("get facebook cover photo.");
        CoverPhoto coverPhoto= facebookTemplate.userOperations().getUserProfile().getCover();
        assumeTrue(StringUtils.isNotBlank(coverPhoto.getSource()) , "can't get reference of user cover photo.");

        UrlResource urlResource;
        try {
            urlResource= new UrlResource(coverPhoto.getSource());
            LOG.info("facebook user cover photo file name: "+urlResource.getFilename());

            assertNotNull(
                    FileCopyUtils.copy( urlResource.getInputStream(),
                                    new FileOutputStream(urlResource.getFilename()    )
                    ), "can't copy file."
            );

        } catch (MalformedURLException ex) {
            LOG.error(ex);
        } catch (IOException e) {
            LOG.error(e);
        }

    }

    @Test
    void testGetProfileImage() throws IOException {
        LOG.info("get profile image.");
        byte [] profileImageBytes= facebookTemplate.userOperations().getUserProfileImage();
        assumeTrue(profileImageBytes.length>10, "can't get image profile.");
        FileOutputStream fos= null;
        try {
            fos= new FileOutputStream("facebook_profile_image.png");
            fos.write(profileImageBytes);
            assertEquals(profileImageBytes.length, Files.readAllBytes(new File("facebook_profile_image.png").toPath()).length);
        } catch (FileNotFoundException e) {
            LOG.error(e);
        } finally {
            fos.close();
        }
    }

    @Test
    void testGetAppFriends () {
        LOG.info("get facebook app friends.");
        facebookTemplate.friendOperations().getFriendProfiles().forEach((User user) -> {
            LOG.info("id: "+user.getId());
            LOG.info("firstName: "+user.getFirstName());
            LOG.info("lastName: "+user.getLastName());
            LOG.info("name: "+user.getName());
            LOG.info("email address: "+user.getEmail());
            LOG.info("about you: "+user.getAbout());
            assertTrue(true, "app friend list accessible.");
        });

        facebookTemplate.friendOperations().getFriends().forEach( (Reference ref) -> {
            LOG.info("ID: "+ref.getId());
            LOG.info("NAME: "+ref.getName());
        });

    }

    @Test
    void testGetPost () {
        facebookTemplate.feedOperations().getFeed().forEach( (Post post) -> {
            LOG.info("POST ID: "+post.getId());
            LOG.info("NAME: "+post.getName());
            LOG.info("POST SOURCE: "+post.getSource());
            LOG.info("POST CAPTION: "+post.getCaption());
            LOG.info("POST DESCRIPTION: "+post.getDescription());
            LOG.info("POST PICTURE: "+post.getPicture());
            LOG.info("POST POST TYPE: "+post.getType().name());
            LOG.info("POST STATUS TYPE:  "+post.getStatusType().name());

            if(!CollectionUtils.isEmpty(post.getWithTags()))
                post.getWithTags().forEach((Reference ref) -> {
                    LOG.info("\t\t to: "+ref.getName());
                });

            if(!CollectionUtils.isEmpty(post.getProperties()))
                post.getProperties().forEach((PostProperty prop) -> {
                    LOG.info("\t\t NAME: "+prop.getName()+" \t\t, TEXT "+prop.getText());
                });

            LOG.debug("***********************************************");
            assertNotNull(post.getId(), "id post must not be null");
        });
    }

}