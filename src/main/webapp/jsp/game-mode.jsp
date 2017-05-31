<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 5/28/17
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path1 = request.getContextPath();
    String bastPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<html>
<head>
    <title>Title</title>
    <p>a:<%=path1%></p>
    <p>b:<%=bastPath%></p>
    <div>
        <table width="100%" border=1>
            <c:forEach items="${modeList}" var="item">
                <tr>
                    <td>
                            ${item.modename}
                    </td>
                    <td>
                            ${item.xsize}
                    </td>
                    <td>
                            ${item.ysize}
                    </td>
                    <td>
                        <a href="<%=bastPath%>game/${item.modeid}">Start</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</head>
<body>

</body>
</html>
