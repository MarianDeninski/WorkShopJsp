<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
    <title>Title</title>
</head>
<body>
<% int statusCode = response.getStatus();%>
<main>
    <header>
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main>
    <div class="container">
        <div class="jumbotron">
            <div class="row">
                <div class="col col-mid-12 d-flex justify-content-center">
                    <p>
                        <img src="https://http.cat/<%=statusCode%>" alt="kitty">
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col col-mid-12 d-flex justify-content-center">
                    <a href="/">Back to home page</a>
                </div>
            </div>
        </div>
    </div>
    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</main>
</body>
</html>
