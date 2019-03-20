<%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 09.11.2018
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="demo-disable-bg-image">
<div id="sampleDemo" style="" class="demo-padding demo-container">
    <div id="componentDemoContent" style="width: 1px; min-width: 100%;">

        <div id="formId">
            <oj-label id="agreeId" show-required>License Agreement </oj-label>
            <oj-checkboxset id="checkboxSetAgreeId" labelled-by="agreeId"
                            value="{{agreement}}"
                            required >
                <oj-option id="agree" value="agree">I Agree</oj-option>
            </oj-checkboxset>
            <br/>
            <span>Current component value is: </span>
            <span id="curr-value" data-bind="text: agreement"></span>
            <br/>
            <br/>
            <br/>
            <oj-label id="mainlabelid">Colors</oj-label>
            <!-- You need to set the labelled-by attribute
                 to make this accessible.
                 role="group" is set for you by oj-checkboxset. -->
            <oj-checkboxset id="checkboxSetId" labelled-by="mainlabelid"
                            value="{{currentColor}}">
                <oj-option id="blueopt" value="blue">Blue</oj-option>
                <oj-option id="greenopt" value="green">Green</oj-option>
                <oj-option id="redopt" value="red">Red</oj-option>
                <oj-option id="limeopt" value="lime">Lime</oj-option>
                <oj-option id="aquaopt" value="aqua">Aqua</oj-option>
            </oj-checkboxset>
            <br/>
            <span>Current component value is: </span>
            <span id="curr-value1" data-bind="text: currentColor"></span>
            <br/>
            <br/>
            <div id='buttons-container'>
                <a href="description.html"></a>
                <oj-button id='inputButton3' on-oj-action='[[setModelCurrentColorToAquaBlue]]'>Set model currentColor to aqua, blue</oj-button>
            </div>

        </div>


    </div>
</div>
</body>
</html>
