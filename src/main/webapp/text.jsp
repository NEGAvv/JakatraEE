<%@ page import="beans.TextBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message Bean</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Bean with Text
            <a href="index.jsp">Home</a>
        </h1>
    </header>

    <jsp:useBean id="textBean" scope="page" class="beans.TextBean"/>
    <jsp:setProperty name="textBean" property="text"/>

    <div>
        <form method="post">
            <label for="text">Text to display: </label>
            <input id="text" name="text" type="text" value="<jsp:getProperty name='textBean' property='text'/>" required/>
            <button type="submit">Submit</button>
        </form>
    </div>

    <div>
        <p><jsp:getProperty name="textBean" property="text" /></p>
    </div>
</div>
</body>
</html>
