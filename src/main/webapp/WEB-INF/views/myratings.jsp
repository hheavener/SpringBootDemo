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
    <jsp:param name="title" value="My Ratings"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="${contextPath}">Home</a> / My Ratings</p>
    <div class="table_title">
        <h1>My Ratings</h1>
        <c:if test="${user != null}">
            <form action="rated" method="POST">
                <select name="sort" onchange="this.form.submit()">
                    <option value="new_old" ${sortOrder == 'new_old' ? 'selected' : ''}>Newest to oldest</option>
                    <option value="old_new" ${sortOrder == 'old_new' ? 'selected' : ''}>Oldest to Newest</option>
                    <option value="high_low" ${sortOrder == 'high_low' ? 'selected' : ''}>High to Low</option>
                    <option value="low_high" ${sortOrder == 'low_high' ? 'selected' : ''}>Low to High</option>
                    <option value="unsaved" ${sortOrder == 'unsaved' ? 'selected' : ''}>Unsaved Only</option>
                </select>
            </form>
        </c:if>
    </div>
    <c:if test="${user != null && not empty user.ratedItems}">
        <table>
            <tr>
                <th>Preview</th>
                <th>Name</th>
                <th>Category</th>
                <th>Rating</th>
                <th>Saved</th>
                <th></th>
            </tr>
            <c:forEach items="${user.ratedItems}" var="upi">
                <tr>
                    <td class="table-img">
                        <a href="${contextPath}/catalog/${upi.product.productCode}">
                            <img src="${upi.product.imageUrl}" alt="${upi.product.name}" width="150">
                        </a>
                    </td>
                    <td>
                        <a href="${contextPath}/catalog/<c:out value="${upi.product.productCode}"/>">
                            <c:out value="${upi.product.name}"/>
                        </a>
                    </td>
                    <td><c:out value="${upi.product.category}"/></td>
                    <td>
                        <a href="${contextPath}/myratings/${upi.product.productCode}/feedback" class="">
                            <c:out value="${upi.ratingAsString}${upi.rating > 0 ? ' / 5' : ''}"/>
                        </a>&nbsp;
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${!user.hasItemSaved(upi.product.productCode)}">
                                <a href="${contextPath}/myratings/${upi.product.productCode}/save" class="button green">Save</a>
                            </c:when>
                            <c:otherwise><img src="Icons/saved_icon.png" width="20" alt="saved" title='Saved to your items'></c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="${contextPath}/myratings/${upi.product.productCode}/delete" class="button red confirmRating">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${user == null}">
        <div class="center-text">
            <p>Please <a href="${contextPath}/login/myratings">sign in</a> to view your ratings</p>
        </div>
    </c:if>
    <c:if test="${user != null && empty user.ratedItems}">
        <div class="center-text">
            <p>When you rate items, they will appear here.</p>
        </div>
    </c:if>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>

