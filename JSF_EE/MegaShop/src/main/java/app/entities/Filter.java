package app.entities;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "searchFilter")
@SessionScoped
public class Filter {

    private Double input1 = new Double(0);
    private Double input2 = new Double(0);
//    private Double input3 = new Double(0);
//    private Double input4 = new Double(0);
//    private Double input5 = new Double(0);
//    private Double input6 = new Double(0);
//    private Double input7 = null;
//    private BigDecimal input8 = new BigDecimal(0);


    public void InputNumberView() {
        input1 = 0d;
        input2 = 0d;
//        input3 = 0d;
//        input4 = 0d;
//        input5 = 251.31;
//        input6 = 60d;
//        input8 = new BigDecimal("1234.000000001");
    }

    public Double getInput1() {
        return input1;
    }

    public void setInput1(Double input1) {
        this.input1 = input1;
    }

    public Double getInput2() {
        return input2;
    }

    public void setInput2(Double input2) {
        this.input2 = input2;
    }



    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void buttonAction() {
        addMessage("Welcome to Primefaces!!");
    }
}
