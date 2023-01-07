<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>

<body>
<div>
    <h3> Choose File to Upload in Server </h3>
    <form action="MyWebdavServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="file" multiple="multiple" />
        <input type="submit" value="upload" />
    </form>
</div>

</body>


<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--<a href="mojtaba-servlet">Mojtaba Servlet</a>--%>
<%--<a href="webdav">webdav Servlet</a>--%>
<%--</br>--%>
<%--<form action="MyWebdavServlet" method="post" enctype="multipart/form-data">--%>
<%--    Select File to Upload:<input type="file" name="fileName">--%>
<%--    <br>--%>
<%--    <input type="submit" value="Upload">--%>
<%--</form>--%>

<%--</body>--%>





</html>