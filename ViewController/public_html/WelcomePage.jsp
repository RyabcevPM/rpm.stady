<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
    <af:document title="WelcomePage.jsp" id="d1">
        <af:form id="f1">
            <af:decorativeBox id="db1">
                <f:facet name="center">
                    <af:panelGroupLayout id="pgl2" layout="vertical">
                        <af:commandButton text="commandButton 1" id="cb1" action="\\test1"/>
                        <af:commandButton text="commandButton 2" id="cb2"/>
                        <af:commandButton text="commandButton 3" id="cb3"/>
                        <h:outputFormat value="outputFormat1" id="of1">
                            <p>
                                &nbsp;
                            </p>
                            <p>
                                <af:inputText label="Label 1" id="it1"/>
                            </p>
                        </h:outputFormat>
                    </af:panelGroupLayout>
                </f:facet>
                <f:facet name="top">
                    <f:verbatim>
                        <strong>
                            <font color="#0000d6" size="5">
                                Welcome page!
                            </font></strong>
                    </f:verbatim>
                </f:facet>
            </af:decorativeBox>
        </af:form>
    </af:document>
</f:view>