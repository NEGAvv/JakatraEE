<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateBean" class="beans.DateBean" scope="page" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jakarta EE Practice Work 3</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <header >
        <h1>Practice Work 3</h1>
    </header>

    <div>
        <a href="text.jsp">Set and Get Text</a>

        <section>
            <h2>Current Date and Time in Kyiv:</h2>
            <p>${dateBean.formattedDate}</p>
        </section>
    </div>

</div>
</body>
</html>
