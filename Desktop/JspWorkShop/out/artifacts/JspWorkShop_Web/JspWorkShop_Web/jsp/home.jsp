<%@ page import="metube.domain.models.view.AllVideosViewModel" %>
<%@ page import="metube.domain.entities.Tube" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <header>
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main>
        <hr class="my-3"/>

        <div class="text-center mt-3">
            <h4 class="h4 text-info">Welcome, <%= request.getSession().getAttribute("username")%></h4>
        </div>
        <hr class="my-4">
        <div class="container" >


            <%List<Tube> tubes = ((AllVideosViewModel)request.getAttribute("allVideos")).getTubes();
                for(Tube tube :tubes) { %>

                    <iframe src="https://www.youtube.com/embed/<%=tube.getYoutubeId()%>" allowfullscreen
                            frameborder="0">
                    </iframe>
            <% } %>
        </div>
        <hr class="my-3"/>
    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
