<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Image Search</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/css/main.css" />
</head>
<body>

<!-- Header -->
<header id="header">
    <div class="inner">
        <div class="content">
            <h1>Owary Image Search</h1>
            <h2>Image search website<br />
            </h2>
            <a href="#" class="button big alt"><span>Let's Go</span></a>
        </div>
        <a href="#" class="button hidden"><span>Let's Go</span></a>
    </div>
</header>

<!-- Main -->
<div id="main">
    <br><br><br>
    <div class="search">
        <form> <!--action="search" method="post"-->
            <div class="bar">
                <input type="text" name="keyword" id ="keyword" placeholder="e.g. Nature">
                <br>
                <%--<input type="submit" name="" value="Search">--%>

                <a class="searchbtn" href="javascript:search();">Search</a>
                <%--<a class="searchbtn" href="javascript:search();">Random</a>--%>
            </div>
        </form>
    </div>

    <div class="inner" id="inner">
    <div class="columns" id="columns">
        <c:if test="${condition}">
            <c:forEach items="${list}" var="image">
                <div class="image fit">
                    <a href="${image.raw}" target="_blank"><img src="${image.regular}" alt="" /></a>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
</div>

<!-- Footer -->
<footer id="footer">
    <a href="#" class="info fa fa-info-circle"><span>About</span></a>
    <div class="inner">
        <div class="content">
            <h3>Mensur Owary - Image Search</h3>
            <p>This is an image search project which is working with an API which I don't want to give the name of :P</p>
        </div>
        <div class="copyright">
            <h3>Follow me</h3>
            <ul class="icons">
                <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            </ul>
            &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>
        </div>
    </div>
</footer>

<!-- Scripts -->
<script src="${contextPath}/js/jquery.min.js"></script>
<script src="${contextPath}/js/skel.min.js"></script>
<script src="${contextPath}/js/util.js"></script>
<script src="${contextPath}/js/main.js"></script>
<script src="${contextPath}/js/ajaxx.js"></script>

</body>
</html>

