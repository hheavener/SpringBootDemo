<%-- 
    Document   : item
    Created on : Oct 2018
    Author     : Hunter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${product == null}"><c:redirect url="/${contextPath}/catalog"/></c:if>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="${product.name}"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / <a href="${contextPath}/catalog">Categories</a> / ${product.name}</p>
    <h1>${product.name}
        <c:if test="${user.hasItemSaved(product.productCode)}">
            <img src="${contextPath}/Icons/saved_icon.png" width="15" alt="saved" title='Saved to your items'>
        </c:if>
        <br>
        <c:if test="${user.hasRatingForItem(product.productCode)}">
            <span class="reg_text">My Rating:</span>
            <c:forEach begin="1" end="${user.getUserProductInfoById(product.productCode).rating}">
                <img src="${contextPath}/Icons/yellow-star.png" width="15" alt="star" title='${user.getUserProductInfoById(product.productCode).rating} stars'>
            </c:forEach>
            <span class="reg_text">(${user.getUserProductInfoById(product.productCode).rating} stars)</span>
        </c:if>
    </h1>
    <div class="imgContainer">
        <img src="${contextPath}/${product.imageUrl}" alt="${product.name}" title="${product.name}" height="300">
        <c:choose>
            <c:when test="${fn:contains(previous, 'feedback')}">
                <br><a href="categories" class="button back-button">Back</a>
            </c:when>
            <c:otherwise>
                <br><a href="${previous}" class="button back-button">Back</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${user != null}">
                <c:choose>
                    <c:when test="${user.hasItemSaved(product.productCode)}">
                        <a href="${contextPath}/catalog/${product.productCode}/delete" class="button action-button red confirm" title='Delete from your items'>Delete</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${contextPath}/catalog/${product.productCode}/save" class="button action-button green">Save It</a>
                    </c:otherwise>
                </c:choose>
                    <a href="${contextPath}/catalog/${product.productCode}/feedback" class="button action-button blue">Rate It</a>
            </c:when>
            <c:otherwise>
                <p style="float:right; margin:5px;">
                    <a href="${contextPath}/login/catalog/${product.productCode}">Sign in</a> to save or rate this product
                </p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
