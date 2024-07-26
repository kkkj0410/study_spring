<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <%--<li>id = ((Member)request.getAttribute("member")).getId()%></li>    --%>
    <%--위의 코드가 아래처럼 생략된 것    --%>
    <li>id = ${member.id}</li>
    <li>username = ${member.username}</li>
    <li>age = ${member.age}</li>
</ul>
<a href = "/index.html">메인</a>
</body>
</html>
