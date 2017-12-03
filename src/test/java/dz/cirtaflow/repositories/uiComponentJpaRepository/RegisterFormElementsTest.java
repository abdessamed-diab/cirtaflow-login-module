package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations ={
                "classpath:testApplicationContext.xml"  ,
                "classpath:test.activiti.cfg.xml"
        })
public class RegisterFormElementsTest implements Serializable {
    private static final Logger LOG= LogManager.getLogger(RegisterFormElementsTest.class);

    private static View registerForm;
    private static UI<InputText> firstName;
    private static UI<InputText> lastName;
    private static UI<InputText> emailAddress;
    private static UI<InputPassword> password;
    private static UI<InputEmail> email;
    private static ButtonElement button;

    @Autowired(required = true)
    private ViewRepository viewRepository;

    @Autowired(required = true)
    private InputRepository nodeRepository;

    @Autowired(required = true)
    private InputTextRepository inputTextRepository;

    @Autowired(required = true)
    private InputPasswordRepository inputPasswordRepository;

    @Autowired(required = true)
    private InputEmailRepository inputEmailRepository;

    @Autowired(required = true)
    private ButtonElementRepository buttonButtonRepository;

    public RegisterFormElementsTest() {

    }

    /**
     * init all register form inputs without saving.
     */
    @BeforeAll
    public static void beforeAll() {
            initRegisterForm();
            initFirstName();
            initLastName();
            initPassword();
            initEmail();
            initButton();
    }

    /**
     * in order to initiate the form register view, we need to persist all the nodes without deleting them
     * before each after each methods will not handle save or delete form nodes.
     */
    @BeforeEach
    public void beforeEach() {

    }

    /**
     * save register form view and its associated nodes.
     */
    @Test
    public void testSaveInputText() {
        // since register from view has unique attribute, we must ensure duplicates.
        if(!this.viewRepository.existsByName(this.registerForm.getName()))
            registerForm= this.viewRepository.save(registerForm);

        this.inputTextRepository.save(firstName.getNode());
        this.inputTextRepository.save(lastName.getNode());
        this.inputPasswordRepository.save(password.getNode());
        this.inputEmailRepository.save(email.getNode());
        this.buttonButtonRepository.save(button);

        assertNotNull(this.firstName.getNode().getPk(), "save input text did not pass.");
    }

    @Test
    public void testDeleteAll() {
        this.viewRepository.deleteAll();
        assertTrue(this.inputTextRepository.count() <1, "delete did not pass.");
    }

    public static View initRegisterForm() {
        registerForm= new View( null, "register_form");
        registerForm.setFormAction("/register");
        registerForm.setFormName("register_form");
        registerForm.setFormMethod(HttpMethod.POST.name());
        registerForm.setFormEncType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return registerForm;
    }

    public static UI<InputText> initFirstName() {
        firstName= new UI<>(InputText.class.getSimpleName());
        firstName.getNode().setType("text");
        firstName.getNode().setName("first");
        firstName.getNode().setPlaceholder("firstname");
        firstName.getNode().setDisabled(false);
        firstName.getNode().setRequired(false);
        firstName.getNode().setClassName("ui-input-text");
        firstName.getNode().setMaxLength(32L);
        firstName.getNode().setTitle("enter your firstname");
        firstName.getNode().setReadOnly(false);
        firstName.getNode().setValidationMessage("first name is required.");
        firstName.getNode().setId("register_form_");
        firstName.getNode().setViewId(registerForm);
        return firstName;
    }

    public static UI<InputText> initLastName() {
        lastName= new UI<>(InputText.class.getSimpleName());
        lastName.getNode().setType("text");
        lastName.getNode().setName("last");
        lastName.getNode().setPlaceholder("lastname");
        lastName.getNode().setDisabled(false);
        lastName.getNode().setRequired(true);
        lastName.getNode().setClassName("ui-input-text");
        lastName.getNode().setMaxLength(32L);
        lastName.getNode().setTitle("enter your lastname");
        lastName.getNode().setReadOnly(false);
        lastName.getNode().setAccessKey("l");
        lastName.getNode().setValidationMessage("last name is required.");
        lastName.getNode().setId("register_form_");
        lastName.getNode().setViewId(registerForm);
        return lastName;
    }

    public static UI<InputText> getEmailAddress() {
        return emailAddress;
    }

    /**
     * init inputPassword value.
     * Password pattern (UpperCase, LowerCase and Number).
     * @return InputPassword
     */
    public static UI<InputPassword> initPassword() {
        password= new UI<>(InputPassword.class.getSimpleName());
        password.getNode().setType("password");
        password.getNode().setName("pwd");
        password.getNode().setPlaceholder("your password");
        password.getNode().setDisabled(false);
        password.getNode().setRequired(true);
        password.getNode().setClassName("ui-input-text");
        password.getNode().setMaxLength(32L);
        password.getNode().setTitle("enter your password");
        password.getNode().setReadOnly(false);
        password.getNode().setAccessKey("p");
        password.getNode().setValidationMessage("password is required.");
        password.getNode().setId("register_form_");

        password.getNode().setPattern("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
        password.getNode().setViewId(registerForm);
        return password;
    }

    public static UI<InputEmail> initEmail() {
        email = new UI<>(InputEmail.class.getSimpleName());
        email.getNode().setType("email");
        email.getNode().setName("email");
        email.getNode().setPlaceholder("your email");
        email.getNode().setDisabled(false);
        email.getNode().setRequired(true);
        email.getNode().setClassName("ui-input-text");
        email.getNode().setMaxLength(32L);
        email.getNode().setTitle("enter your email");
        email.getNode().setReadOnly(false);
        email.getNode().setAccessKey("e");
        email.getNode().setValidationMessage("email address is required.");
        email.getNode().setId("register_form_");
        email.getNode().setViewId(registerForm);

        return email;
    }

    public static ButtonElement initButton() {
        button= new ButtonElement();
        button.setContent("register");
        button.setType(ButtonElement.SUBMIT);

        button.setClassName("ui-button");
//        button.setTitle("submit you data.");
        button.setViewId(registerForm);
        return button;
    }
}
