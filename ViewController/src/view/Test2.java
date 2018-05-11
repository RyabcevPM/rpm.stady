package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name="MagicText")
@RequestScoped
public class Test2 {
    private HtmlOutputText magicText;
    private String inputText;
    private String oututText;
    

    public Test2() {
        oututText = "Hello World!";
    }

    public void setMagicText(HtmlOutputText magicText) {
        this.magicText = magicText;
    }

    public HtmlOutputText getMagicText() {
        return magicText;
    }


    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setOututText(String oututText) {
        this.oututText = oututText;
    }

    public String getOututText() {
        return oututText;
    }

    public Object commandButton_action() {
        // Add event code here...
        setOututText(getInputText());
        return null;
    }
}
