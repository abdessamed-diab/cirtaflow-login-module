package dz.cirtaflow.web;

import dz.cirtaflow.beans.DefaultSingletonBeanStructure;
import dz.cirtaflow.models.ui.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDate;

@RestController(value = "inputsRestController")
@RequestMapping(value = "/cirtaflow/inputs")
public class ClientRestRequestHandler implements Serializable, DefaultSingletonBeanStructure{
    private static final Logger LOG= LogManager.getLogger(ClientRestRequestHandler.class);

    public ClientRestRequestHandler() {
        LOG.debug("init constructor.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.debug("after properties set.");
    }

    @Override
    public void destroy() throws Exception {
        LOG.debug("destroy bean.");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register", produces = "application/hal+json")
    public InputText[] getRegisterPopupInputs() {
        LOG.info("get register popup inputs ...");
        InputNumber input= new InputNumber("input-number-1",
                15.0);

        input.setRequired(true);
        input.setDisabled(false);
        input.setReadOnly(false);
//        input.setHidden();
//        input.setType("text");
        input.setName("selected_Country");
        input.setPlaceholder("your country number");
        input.setSize(16L);
        input.setMaxLength(50L);
        input.setClassName("ui-input-text");
        input.setTitle("enter your country number!");

        input.setMin("10.0");
        input.setMax("30.0");

        InputText inText= new InputText("input-text-2", "DIAB");
        inText.setClassName("ui-input-text");

        InputCheckBox check= new InputCheckBox("check-box-1", false, "check_box_name", "audi");
        InputCheckBox check2= new InputCheckBox("check-box-2", true, "check_box_name_2", "bmw");
        check.setContent("first world car");
        check2.setContent("second world car ");

        InputRadio radio = new InputRadio("input-radio-1", false, "gender", "car");
        InputRadio radio2 = new InputRadio("input-radio-2", true, "gender", "track");
        InputRadio radio3 = new InputRadio("input-radio-3", false, "gender", "plane");
        radio.setContent("CAR");
        radio2.setContent("TRACK");
        radio3.setContent("PLANE");

        InputPassword pass= new InputPassword("input-password-1", "0", "10");
        pass.setClassName("ui-input-text");

        InputDate date= new InputDate("input-date-1", true);
        date.setType(InputDate.DATE);
        date.setClassName("ui-input-text");
        date.setValue(LocalDate.of(2017, 11, 27));

        InputText[] inputs= new InputText[]{
                input,
                inText,
                check,
                check2,
                radio,
                radio2,
                radio3,
                pass,
                date
        };

        return inputs;

    }


}
