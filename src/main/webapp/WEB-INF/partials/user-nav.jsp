<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="user-navigation">
    <nav>
        <c:choose>
            <c:when test="${user == null}">
                <a href="${contextPath}/login" class="${pageContext.request.requestURI.contains('login') ? 'active' : ''}">Sign in</a><span> | </span>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/profile" class="${pageContext.request.requestURI.contains('profile') ? 'active' : ''}">My Profile</a><span> | </span>
            </c:otherwise>
        </c:choose>
        <a href="${contextPath}/mysaved" class="${pageContext.request.requestURI.contains('mysaved') ? 'active' : ''}">My Saved</a><span> | </span>
        <a href="${contextPath}/myratings" class="${pageContext.request.requestURI.contains('myratings') ? 'active' : ''}">My Ratings</a>
    </nav>
</div>