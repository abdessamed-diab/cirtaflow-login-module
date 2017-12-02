package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UI<T extends Node> implements Serializable {
    private static final Logger LOG= LogManager.getLogger(UI.class);
    public T node;

    public  UI(String clazzName) {
        try {
            if(InputText.class.getSimpleName().equalsIgnoreCase(clazzName))
                this.node= (T) InputText.class.newInstance();

            if(InputPassword.class.getSimpleName().equalsIgnoreCase(clazzName))
                this.node= (T) InputPassword.class.newInstance();

            if(InputEmail.class.getSimpleName().equalsIgnoreCase(clazzName))
                this.node= (T) InputEmail.class.newInstance();

            if(ButtonElement.class.getSimpleName().equalsIgnoreCase(clazzName))
                this.node= (T) ButtonElement.class.newInstance();


            initRequiredFields();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void initRequiredFields() {
        LOG.debug("****** start initializing required fields *********");

        Arrays.asList(  this.node.getClass().getMethods() ).stream()
                .filter( method -> {
                    if(method.isAnnotationPresent(Column.class)
                            && !method.isAnnotationPresent(Id.class)
                            && !method.isAnnotationPresent(Transient.class))
                        return true;
                    else
                        return method.getName().toLowerCase().startsWith("set");
                }).filter(method -> {
                    if(method.getName().toLowerCase().startsWith("get") || method.getName().toLowerCase().startsWith("is")  ){
                        Column columnAnnotation  = method.getAnnotation(Column.class);
                        return !columnAnnotation.nullable();
                    }
                    return method.getName().toLowerCase().startsWith("set");
                }).forEach( (Method method) -> {
                    if( method.getName().toLowerCase().startsWith("get") || method.getName().toLowerCase().startsWith("is") ){
                        try {
                            if(method.getReturnType().isAssignableFrom(Boolean.class))
                                    this.node.getClass().getMethod(
                                            method.getName().replaceFirst("is", "set")
                                            , method.getReturnType()
                                    ).invoke(node, Boolean.FALSE);

                            if(method.getReturnType().isAssignableFrom(String.class))
                                this.node.getClass().getMethod(
                                        method.getName().replaceFirst("get", "set")
                                        , method.getReturnType()
                                ).invoke(node, method.getName().substring(3, method.getName().length()-1)+this.node.getId());

                        } catch (NoSuchMethodException e) {
                            LOG.error(e);
                        } catch (IllegalAccessException e) {
                            LOG.error(e);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });

        LOG.debug("****** required fields initialized *********");
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }
}
