<%-- 
    Document   : swap
    Created on : Oct 2018
    Author     : Hunter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="Feedback | ${product.name}"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / <a href="categories">Categories</a> / <a href="${contextPath}/catalog/${product.productCode}">${product.name}</a> / Feedback</p>
    <h1>${product.name}
        <c:if test="${user.hasItemSaved(product.productCode)}">
            <img src="${contextPath}/Icons/saved_icon.png" width="15" alt="saved" title='Saved to your items'>
        </c:if>
    </h1>
    <div class="imgContainer">
        <img src="${contextPath}/${product.imageUrl}" alt="${product.name}" title="${product.name}" height="300">
        <hr>
        <h2>Feedback:</h2>
        <c:choose>
            <c:when test="${user != null}">
                <form action="${contextPath}/catalog/${product.productCode}/feedback" method="POST">
                    <p>My Rating:
                        <select name="rating">
                            <option value="0" ${user.getRatingById(product.productCode) == 0.0 ? 'selected="selected"' : ''}>None</option>
                            <option value="1" ${user.getRatingById(product.productCode) == 1.0 ? 'selected="selected"' : ''}>1</option>
                            <option value="2" ${user.getRatingById(product.productCode) == 2.0 ? 'selected="selected"' : ''}>2</option>
                            <option value="3" ${user.getRatingById(product.productCode) == 3.0 ? 'selected="selected"' : ''}>3</option>
                            <option value="4" ${user.getRatingById(product.productCode) == 4.0 ? 'selected="selected"' : ''}>4</option>
                            <option value="5" ${user.getRatingById(product.productCode) == 5.0 ? 'selected="selected"' : ''}>5</option>
                        </select>
                    </p>

                    <input type="hidden" name="referer" value="${referer}">

                    <br><br><a href="${contextPath}/catalog/${product.productCode}" class="button back-button">Cancel</a>
                    <input type="submit" value="Confirm" class="button action-button green">
                </form><br><br>
            </c:when>
            <c:otherwise>
                <p><a href="${contextPath}/login/catalog/${product.productCode}/feedback">Sign in</a> to give feedback on this product</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
