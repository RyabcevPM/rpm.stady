<%@ page import="java.util.Date" %>
<%@ page import="jsp.JSPHelper" %><%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 04.10.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! int i = 5;%>
<%! private void doJob() {
    System.out.println("hello from expression");
}%>
<%= "hello world from declaretion" %>
<br></br>
<%= i + 1 + 2 %>
<br></br>
<%= new Date()%>
<br></br>
<%= JSPHelper.getFacotial(5) %>
<% class AngryMan {
    String name;

    public String getName() {
        return name;
    }

    public AngryMan() {
        this.name = "None";
    }

    public void setName(String name) {
        this.name = name;
    }

}
%>
<br></br>
<% AngryMan s = new AngryMan(); %>
<%= s.getName() %>
<br></br>
<% s.setName("RPM1"); %>
<%= s.getName() %>
<br></br>
<% if (Math.random() > 0.5) { %>
  Random hello
<% } %>

</body>
</html>
