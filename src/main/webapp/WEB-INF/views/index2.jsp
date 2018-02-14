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
<!-- <header id="header">
    <div class="inner">
        <div class="content">
            <h1>Radius</h1>
            <h2>A fully responsive masonry-style<br />
            portfolio template.</h2>
            <a href="#" class="button big alt"><span>Let's Go</span></a>
        </div>
        <a href="#" class="button hidden"><span>Let's Go</span></a>
    </div>
</header> -->



<!-- Main -->
<div id="main">
    <br><br><br>
    <div class="search">
        <form action="search" method="post">
            <div class="bar">
                <input type="text" name="keyword" placeholder="e.g. Nature">
                <br>
                <input type="submit" name="" value="Search">
            </div>
        </form>
    </div>

    <div class="inner">
        <div class="columns">
            <%----%>
            <!-- Column 1 (horizontal, vertical, horizontal, vertical) -->
                <c:if test="${condition}">
                    <c:forEach items="${list}" var="image">
                        <div class="image fit">
                            <a href="#"><img src="${image.regular}" alt="" /></a>
                        </div>
                    </c:forEach>
                </c:if>

                <c:if test="${testcond}">
                    <h1>Ooops, you have to search for something</h1>
                </c:if>

            <!-- <div class="image fit">
                <a href="detail1.html"><img src="images/pic01.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic02.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic03.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic04.jpg" alt="" /></a>
            </div> -->

            <!-- Column 2 (vertical, horizontal, vertical, horizontal) -->
            <!-- <div class="image fit">
                <a href="detail1.html"><img src="images/pic06.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic05.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic08.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic07.jpg" alt="" /></a>
            </div> -->

            <!-- Column 3 (horizontal, vertical, horizontal, vertical) -->
            <!-- <div class="image fit">
                <a href="detail1.html"><img src="images/pic09.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic12.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic11.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic10.jpg" alt="" /></a>
            </div> -->

            <!-- Column 4 (vertical, horizontal, vertical, horizontal) -->
            <!-- <div class="image fit">
                <a href="detail1.html"><img src="images/pic13.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic14.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic15.jpg" alt="" /></a>
            </div>
            <div class="image fit">
                <a href="detail1.html"><img src="images/pic16.jpg" alt="" /></a>
            </div> -->

        </div>
    </div>
</div>

<!-- Footer -->
<footer id="footer">
    <a href="#" class="info fa fa-info-circle"><span>About</span></a>
    <div class="inner">
        <div class="content">
            <h3>Vestibulum hendrerit tortor id gravida</h3>
            <p>In tempor porttitor nisl non elementum. Nulla ipsum ipsum, feugiat vitae vehicula vitae, imperdiet sed risus. Fusce sed dictum neque, id auctor felis. Praesent luctus sagittis viverra. Nulla erat nibh, fermentum quis enim ac, ultrices euismod augue. Proin ligula nibh, pretium at enim eget, tempor feugiat nulla.</p>
        </div>
        <div class="copyright">
            <h3>Follow me</h3>
            <ul class="icons">
                <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            </ul>
            &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com/">Unsplash</a>.
        </div>
    </div>
</footer>

<!-- Scripts -->
<script src="${contextPath}/js/jquery.min.js"></script>
<script src="${contextPath}/js/skel.min.js"></script>
<script src="${contextPath}/js/util.js"></script>
<script src="${contextPath}/js/main.js"></script>

</body>
</html>

