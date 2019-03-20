package cdi;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;

//** link for setup
//http://openwebbeans.apache.org/owbsetup_se.html

public class OpenWebBeanExample {
    private static ContainerLifecycle lifecycle = null;
    public static void main(String[] args) {
        lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);

        BeanManager beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.getBeans("mainContainer").iterator().next();

        MainContainer mainContainer = (MainContainer) lifecycle.getBeanManager().getReference(bean, MainContainer.class, beanManager.createCreationalContext(bean));
        mainContainer.runBean();

        lifecycle.stopApplication(null);
    }
}

@Named("MainContainer")
class MainContainer {
    @Inject
    MyThreeBean myBean;
    public void runBean(){
        myBean.print();
    }
}

class MyThreeBean {
    public void print() {
        System.out.println("MyThreeBean: Hello world");
    }
}