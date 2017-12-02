package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.util.ReflectionUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeFactory implements Serializable {
    private static final Logger LOG = LogManager.getLogger(NodeFactory.class);
    protected static final String VIEW_NAME= "register_form";

    protected Node node;
    protected View view;

    protected List<Node> nodes= new ArrayList<>();

    public NodeFactory() {
        LOG.debug("default constructor.");
    }

    protected <T> NodeFactory(@NonNull  Class<T> clazz) {
        if( clazz.isAssignableFrom(Node.class) ) {
            LOG.debug("clazz: "+clazz.getSimpleName()+" is assignable from Node class");
            this.node= new Node(
                    new FormElementImpl(),
                    new HtmlElementImpl(),
                    new ElementImpl()
            );

            this.view= new View(null, VIEW_NAME);
            this.view.setFormAction("");
            this.view.setFormName("");
            initNode();

            nodes.add(this.node);
            nodes.add(this.node);
            nodes.add(this.node);
            nodes.add(this.node);
            nodes.add(this.node);
        }

    }

    /**
     * initialize non nullable declared columns with default values according to there types.
     */
    protected void initNode() {
        Arrays.asList(ReflectionUtils.getAllDeclaredMethods(Node.class))
                .stream()
                .filter(  method-> {
                    if(method.isAnnotationPresent(Column.class) && !method.isAnnotationPresent(Id.class)
                            && !method.isAnnotationPresent(GeneratedValue.class))
                        return true;
                    else
                        return method.getName().toLowerCase().startsWith("set");
                })
                .filter(method -> {
                    if(method.getName().startsWith("get") || method.getName().startsWith("is")){
                        Annotation annotation= method.getAnnotation(Column.class);
                        if(!((Column)annotation).nullable())
                            return true;
                    }else
                        return method.getName().toLowerCase().startsWith("set");
                    return false;
                }).forEach((Method method) -> {
                    LOG.info("filtered method: "+method.getName());
                    if(method.getName().toLowerCase().startsWith("get") || method.getName().toLowerCase().startsWith("is")){
                        try {
                            if(method.getReturnType().isAssignableFrom(Boolean.class))
                                Node.class.getDeclaredMethod(
                                        method.getName().replaceFirst("is", "set")
                                        , method.getReturnType()
                                ).invoke(node, Boolean.FALSE);

                            if(method.getReturnType().isAssignableFrom(String.class))
                                Node.class.getDeclaredMethod(
                                        method.getName()
                                                .replace("get", "set")
                                        , method.getReturnType()
                                ).invoke(node, method.getName().substring(3, method.getName().length()-1)+"01");

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
