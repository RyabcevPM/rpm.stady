package webapp1;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ExampleCDI  implements Serializable {
    @EJB
    ExampleEJB exampleEJB;
    private String login;
    private String password;
    private String connectStatus;
    private boolean createSuccess;

    public ExampleEJB getExampleEJB() {
        return exampleEJB;
    }

    public void setExampleEJB(ExampleEJB exampleEJB) {
        this.exampleEJB = exampleEJB;
    }

    public boolean isCreateSuccess() {
        return createSuccess;
    }

    public void setCreateSuccess(boolean createSuccess) {
        this.createSuccess = createSuccess;
    }

    public String getConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(String connectStatus) {
        this.connectStatus = connectStatus;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Connect() {
        connectStatus = exampleEJB.checkPassword(login, password) ? "Connected" : "Login failed";
    }

    public void createUser(){
        createSuccess = exampleEJB.createUser(login, password);
    }
}
