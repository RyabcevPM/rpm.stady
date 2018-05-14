package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name="MagicText")
@RequestScoped
public class Test2 {
    private HtmlOutputText magicText;
    private String inputText;
    private String outputText;
    

    public Test2() {
        outputText = "Hello World!";
        inputText = "New text";
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

    public void setOutputText(String oututText) {
        this.outputText = oututText;
    }

    public String getOutputText() {
        return outputText;
    }

    public Object commandButton_action() {
        // Add event code here...
        setOutputText(getInputText());
        return null;
    }
}
