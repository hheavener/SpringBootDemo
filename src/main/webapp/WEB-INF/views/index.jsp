<!DOCTYPE html>
<html lang="en">
<jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="A3 Demo"/>
</jsp:include>
<body>
<jsp:include page="../partials/header.jsp"/>
<jsp:include page="../partials/user-nav.jsp"/>
<jsp:include page="../partials/site-nav.jsp"/>
<div class="content">
    <p>Home</p>
    <h1>Welcome</h1>
    <p>This demo was created to:</p>
    <ul>
        <li>Demonstrate core concepts of Network Based Application Development (NBAD) Assignment 3</li>
        <li>Provide a working prototype of the assignment for students to interact with</li>
        <li>Inspire students to make their web site the best it can be!</li>
    </ul>
    <br><br><br>
    <p>So have a look around and I hope this is helpful!</p>
    <br><br><br>
    <p>Try these out!</p>
    <ul>
        <li>Look at each page, without signing in, and again after signing in</li>
        <li>Try saving/rating several items and notice how things change on the 'My Items' & 'My Ratings' pages</li>
        <li><strong>BONUS:</strong> Try the filters out on the 'My Items' & 'My Ratings' pages and see if you can replicate them!</li>
    </ul>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>