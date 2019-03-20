package jsp;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ContextListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ContextListener.add " + srae.getName() + " = " + srae.getValue().toString());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ContextListener.remove " + srae.getName() + " = " + srae.getValue().toString());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("ContextListener.update " + srae.getName() + " = " + srae.getValue().toString());
    }

}
