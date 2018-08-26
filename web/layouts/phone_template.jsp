<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!--  sitemesh:title 的作用是，将要修饰的页面的title引入 -->
    <title><sitemesh:title/></title>
    <!-- 不用在意下面的样式引入  -->
    <link href="/js_css/css/bootstrap.css" rel="stylesheet">
    <link href="/js_css/css/offcanvas.css" rel="stylesheet">
</head>

<body class="bg-light">

    <%@include file="phone_head_nva.jsp"%>

    <%@include file="phone_body_nva.jsp"%>


    <main role="main" style="margin-top:0em;">
            <!--  这里会把要修饰的页面的body部分引入 -->
            <sitemesh:body></sitemesh:body>
    </main>

    <%@include file="phone_footer.jsp"%>

</body>
</html>
