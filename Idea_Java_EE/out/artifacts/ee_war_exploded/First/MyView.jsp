<%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 05.10.2018
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple MVC</title>
</head>
<body>
    <br>Expression language example
    <jsp:useBean id="student" class="MVC.Student" scope="request"/>
    <jsp:getProperty name="student" property="name"/>
    <br>
    ${new_student.name}
    <br>
    ${new_student["name"]}
    <br>
    ${requestScope.new_student.name}
    <br>applicationScopeScope<br>
    ${applicationScopeScope.new_student.name}
    <br><br>use list<br><br>
    ${list[1]}
    <br>use map<br><br>
    ${map["one"]}
    <br>
    ${map.two != "2" ? "p1":"p2"}
    <br>
    ${map.two = "2"}
    <br>
    <jsp:useBean id="student2" class="MVC.Student" scope="request"/>
    <jsp:setProperty name="student2" property="name" value="${map.one}"/>
    <jsp:getProperty name="student2" property="name"/>
    <br>
    ${cookie.JSESSIONID}

</body>
</html>
