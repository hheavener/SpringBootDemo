<%-- 
    Document   : hints
    Created on : Feb 27, 2019, 12:30:39 AM
    Author     : Hunter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="About"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p><a href="#{contextPath}">Home</a> / About</p>
    <h1>About</h1>
    <h2>Structure:</h2>
    <ul>
        <li>
            <h3>This application has 7 JSP pages:</h3>
            <ul>
                <li>index.jsp</li>
                <li>about.jsp</li>
                <li>categories.jsp</li>
                <li>item.jsp</li>
                <li>feedback.jsp</li>
                <li>myItems.jsp</li>
                <li>myRated.jsp</li>
            </ul>
        </li>
        <li>
            <h3>This application has 3 servlets</h3>
            <ul>
                <li>
                    Catalog Controller (~10 lines of code)
                    <ul>
                        <li>Handles displaying the 'Categories' & 'Item' page info</li>
                        <li>
                            The profile controller is mapped to 2 URLs
                            <ul>
                                <li>/categories</li>
                                <li>/item</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    Login Controller (~20 lines of code)
                    <ul>
                        <li>Handles routing for 'Home' & 'About' pages in addition to login function</li>
                        <li>
                            The Login controller is mapped to 4 URLs
                            <ul>
                                <li>/login</li>
                                <li>/logout</li>
                                <li>/home</li>
                                <li>/about</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    Profile Controller (~65 lines of code)
                    <ul>
                        <li>Handles user actions (saving, rating, updating, deleting, etc.)</li>
                        <li>Handles the sorting on the 'My Items' and 'My Ratings' pages</li>
                        <li>
                            The profile controller is mapped to 5 URLs
                            <ul>
                                <li>/profile</li>
                                <li>/items</li>
                                <li>/feedback</li>
                                <li>/rated</li>
                                <li>/delete</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <h3>This application has 3 JavaBeans</h3>
            <ul>
                <li>
                    Item.java
                    <ul>
                        <li>Properties: itemCode, name, imageURL, category</li>
                    </ul>
                </li>
                <li>
                    User.java
                    <ul>
                        <li>Properties: firstName, lastName, ArrayList&lt;UserItem&gt; userItems</li>
                    </ul>
                </li>
                <li>
                    UserItem.java
                    <ul>
                        <li>Properties: itemID,
                            <span class="blue-text">int</span> rating,
                            <span class="blue-text">boolean</span> purchased,
                            <span class="blue-text">boolean</span> saved
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>

    <h2>Other:</h2>
    <ul>
        <li>
            <h3>The only pages that show information being passed to servlets through the URL are:</h3>
            <ul>
                <li>The 'item' page</li>
                <li>The 'feedback' page</li>
                <li>The rest of the pages either:
                    <ul>
                        <li>Use POST methods and do not display the info in the URL</li>
                        <li>
                            Or use a GET method mapped to a unique URL with no parameters included
                            <ul>
                                <li>Such as using the '/items' URL to display the 'My Items' page</li>
                                <li>Rather than using something like 'profile?view=myItems'</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <h3>This website is 100% HTML compliant</h3>
            <ul>
                <li>Validate by Right clicking > View page source > Copy > Paste into <a href="https://validator.w3.org/#validate_by_input" target="_blank">validator.w3.org</a></li>
                <li>You can also check out my CSS <a href="${pageContext.servletContext.contextPath}/Styles/style.css" target="_blank">here</a> if, for whatever reason, you want to know how I did it.</li>
            </ul>
        </li>
    </ul><br>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
