<%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 27.03.2019
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title>
    <link rel="stylesheet" href="../styles/b1.css"/>
    <link rel="stylesheet" href="../styles/s1.css"/>

</head>
<body>
<h1>Table example</h1>
<table class="blueTable">
    <thead>
    <tr>
        <th>head1</th>
        <th>head2</th>
        <th>head3</th>
        <th>head4</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td colspan="4">
            <div class="links"><a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>
        </td>
    </tr>
    </tfoot>
    <tbody>
    <tr>
        <td>cell1_1</td>
        <td>cell2_1</td>
        <td>cell3_1</td>
        <td>cell4_1</td>
    </tr>
    <tr>
        <td>cell1_2</td>
        <td>cell2_2</td>
        <td>cell3_2</td>
        <td>cell4_2</td>
    </tr>
    <tr>
        <td>cell1_3</td>
        <td>cell2_3</td>
        <td>cell3_3</td>
        <td>cell4_3</td>
    </tr>
    <tr>
        <td>cell1_4</td>
        <td>cell2_4</td>
        <td>cell3_4</td>
        <td>cell4_4</td>
    </tr>
    </tbody>
</table>
<%--<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">--%>
    <%--<button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>--%>
<%--</div>--%>
<button href="/user_reg" class="a-btn">
    <span class="a-btn-slide-text">$29</span>
    <img src="../images/Doc.png" alt="Photos" />
    <span class="a-btn-text"><small>Available on the Apple</small> App Store</span>
    <span class="a-btn-icon-right"><span></span></span>
</button>

<a href="user_reg" class="a-btn">
    <span class="a-btn-slide-text">$29</span>
    <img src="../images/Doc.png" alt="Photos" />
    <span class="a-btn-text"><small>Available on the Apple</small> App Store</span>
    <span class="a-btn-icon-right"><span></span></span>
</a>

<a href="/index.xhtml" class="a-btn">
    <span class="a-btn-slide-text">Go!</span>
    <img src="../images/Doc.png" alt="Photos" />
    <span class="a-btn-text">to Html</span>
    <span class="a-btn-icon-right"><span>
</a>
</body>


</html>
