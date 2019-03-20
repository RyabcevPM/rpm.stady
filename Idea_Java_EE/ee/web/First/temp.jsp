<%@ page import="jsp.MyTread" %><%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 05.10.2018
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="person" class="jsp.Person" scope="request">
        <jsp:setProperty name="person" property="name" value="Somthing"/>
        <jsp:getProperty name="person" property="name"/>
    </jsp:useBean>
    <br>
    <%! String page_person_name = "RyabcevPM"; %>
    <jsp:setProperty name="person" property="name" value="<%=page_person_name%>" />
    <jsp:getProperty name="person" property="name"/>
    <br>
    <%-- url with param ?name=rpm&age=31 --%>
    <jsp:setProperty name="person" property="*" />
    <jsp:getProperty name="person" property="name"/>
    <jsp:getProperty name="person" property="age"/>
    <br>
    


    <%-- <% Runnable runnable = new MyTread()%>
    <jsp:useBean id="thread" class="jsp.MyTread" type="java.lang.Runnable"/>
    --%>
</body>
</html>
