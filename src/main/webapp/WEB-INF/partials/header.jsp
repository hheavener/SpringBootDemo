
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<header>
    <h1><a href="${contextPath}">Spring Boot Demo</a></h1>
    <c:choose>
        <c:when test="${user == null}">
            <p class="display_name">Not signed in</p>
        </c:when>
        <c:otherwise>
            <p class="display_name">Signed in as <a href="${contextPath}/profile"><c:out value="${user.firstName} ${user.lastName}"/></a></p>
        </c:otherwise>
    </c:choose>
</header>