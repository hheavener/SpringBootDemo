<%--
    Document   : categories
    Created on : Oct 2018
    Author     : Hunter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="Catalog"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / Catalog</p>
    <c:forEach items="${categories}" var="category">
        <h1><c:out value="${category}"/></h1>
        <ul>
            <c:forEach var="i" items="${products}">
                <c:if test="${i.category eq category}">
                    <li>
                        <a href="${contextPath}/catalog/${i.productCode}">${i.name}</a>
                        <c:if test="${user.hasItemSaved(i.productCode)}">
                            <img src="${contextPath}/Icons/saved_icon.png" width="15" alt="saved" title='Saved to your items'>
                        </c:if>
                        <c:if test="${user.hasRatingForItem(i.productCode)}">
                            <img src="${contextPath}/Icons/yellow-star.png" width="15" alt="rated" title='You have rated this item'>
                        </c:if>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </c:forEach>
    <br>
    <c:if test="${user != null}">
        <p>
            <strong>Legend:</strong>&nbsp;
            Saved <img src="${contextPath}/Icons/saved_icon.png" width="15" alt="saved">&nbsp;&nbsp;
            Rated <img src="${contextPath}/Icons/yellow-star.png" width="15" alt="rated">
        </p>
    </c:if>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
