<%-- 
    Document   : myItems
    Created on : Oct 2018
    Author     : Hunter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="My Saved"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / My Saved</p>
    <div class="table_title">
        <h1>My Saved</h1>
        <c:if test="${user != null}">
            <form action="items" method="POST">
                <select name="sort" onchange="this.form.submit()">
                    <option value="new_old" ${sortOrder == 'new_old' ? 'selected' : ''}>Newest to oldest</option>
                    <option value="old_new" ${sortOrder == 'old_new' ? 'selected' : ''}>Oldest to Newest</option>
                    <option value="high_low" ${sortOrder == 'high_low' ? 'selected' : ''}>High to Low</option>
                    <option value="low_high" ${sortOrder == 'low_high' ? 'selected' : ''}>Low to High</option>
                </select>
            </form>
        </c:if>
    </div>
    <c:if test="${user != null && not empty user.userProductInfos}">
        <table>
            <tr>
                <th>Preview</th>
                <th>Name</th>
                <th>Category</th>
                <th>Rating</th>
<%--                <th></th>--%>
                <th></th>
            </tr>
            <c:forEach items="${user.userProductInfos}" var="upi">
                <c:if test="${upi.saved eq true}">
                    <tr>
                        <td class="table-img">
                            <a href="/springdemo/catalog/${upi.product.productCode}">
                                <img src="${upi.product.imageUrl}" alt="${upi.product.name}" width="150">
                            </a>
                        </td>
                        <td>
                            <a href="/springdemo/catalog/<c:out value="${upi.product.productCode}"/>">
                                <c:out value="${upi.product.name}"/>
                            </a>
                        </td>
                        <td><c:out value="${upi.product.category}"/></td>
                        <td>
<%--                            <c:out value="${upi.ratingAsString}"/><c:if test="${upi.rating > 0}"> / 5</c:if>--%>
                            <c:choose>
                                <c:when test="${upi.rating > 0}">
                                    <a href="/springdemo/mysaved/${upi.product.productCode}/feedback">
                                        <c:out value="${upi.ratingAsString} / 5"/>
                                    </a>
                                </c:when>
                                <c:otherwise><a href="/springdemo/mysaved/${upi.product.productCode}/feedback" class="button blue">Rate</a></c:otherwise>
                            </c:choose>
                        </td>
<%--                        <td><a href="/springdemo/catalog/${upi.product.productCode}/feedback" class="button blue">Update</a></td>--%>
                        <td><a href="/springdemo/mysaved/${upi.product.productCode}/delete" class="button red confirm">Delete</a></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${user == null}">
        <div class="center-text">
            <p>Please <a href="login">sign in</a> to view your items</p>
        </div>
    </c:if>
    <c:if test="${user != null && empty user.userProductInfos}">
        <div class="center-text">
            <p>When you add items, they will appear here.</p>
        </div>
    </c:if>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>