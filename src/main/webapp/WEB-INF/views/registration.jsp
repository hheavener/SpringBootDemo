<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / Register</p>
    <h1>Login</h1>
    <c:if test="${message != null}">
        <c:out value="${message}"/><br><br>
    </c:if>
    <div class="login_form">
        <form action="${contextPath}/register" method="post">

            <input type="text" id="f_name" name="f_name" placeholder="First name">

            <input type="text" id="l_name" name="l_name" placeholder="Last name">

            <input type="text" id="email" name="email" placeholder="Email address">

            <input type="password" id="password" name="password" placeholder="Password">

            <input type="password" id="conf_pass" name="conf_pass" placeholder="Confirm password">

            <input type="submit" value="Sign up">

            <a href="${contextPath}/login">Sign in</a>
        </form>
    </div>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>