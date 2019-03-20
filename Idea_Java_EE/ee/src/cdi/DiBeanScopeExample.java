package cdi;

import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/di2")
public class DiBeanScopeExample extends HttpServlet {
    @Inject
    MyBean myBean;

    @Inject
    ChangeMyBean changeMyBean;

    @Inject
    ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myBean.id = 5;
        changeMyBean.changeId();
        resp.getWriter().write(Integer.toString(myBean.id) + ";  " + changeMyBean.myBean.id);
        ////////////
        System.out.println("one:" + conversationBean.getId());
        conversationBean.setId(1);
        conversationBean.doJob();
        conversationBean.startConversation();
        System.out.println("one:" + conversationBean.getId());
        System.out.println("middle conversation");
        conversationBean.setId(3);
        conversationBean.endConversation();
        System.out.println("one:" + conversationBean.getId());
    }
}

//cdi
//@ApplicationScoped
//@SessionScoped
//@RequestScoped
//@ConversationScoped
//@Dependent
class MyBean {
    int id = 0;
}

class ChangeMyBean {
    @Inject
    MyBean myBean;

    public void changeId() {
        myBean.id = 2;
    }
}


@ConversationScoped
class ConversationBean implements Serializable{

    @Inject
    Conversation conversation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public void doJob(){
        System.out.println("two:" + id);
    }

    public void startConversation(){
        System.out.println("two:" + id);
        System.out.println("start conversation");
        conversation.begin();
        setId(2);
    }

    public void endConversation(){
        System.out.println("two:" + id);
        System.out.println("end conversation");
        conversation.end();
    }
}