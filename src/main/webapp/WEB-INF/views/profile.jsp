<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="${user.firstName}'s profile"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / My Profile</p>
    <h1>My Profile</h1>
    <c:if test="${message != null}">
        <c:out value="${message}"/><br><br>
    </c:if>

    <form action="${contextPath}/user_info" method="post">
        <input type="text" name="f_name" value="<c:out value="${user.firstName}"/>">
        <input type="text" name="l_name" value="<c:out value="${user.lastName}"/>">
        <br><br>
        <input type="text" name="email" value="<c:out value="${user.email}"/>">
        <br><br>
        <input type="submit" value="Update">
    </form>

    <br>
    <p><a href="${contextPath}/logout">Sign out</a></p>

</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>