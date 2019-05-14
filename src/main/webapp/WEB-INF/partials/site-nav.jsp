<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="site-navigation">
    <nav>
        <ul>
            <li><a href="${contextPath}/">Home</a></li>
            <li><a href="${contextPath}/catalog">Catalog</a></li>
            <li><a href="${contextPath}/about">About</a></li>
        </ul>
    </nav>
</div>