<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<h2>How to iterate list on JSP in Spring MVC</h2>

<p><b>Simple List:</b><p>

    ${feedbacks}

<p><b>Iterated List:</b><p>

<ol>
    <c:forEach var="emp" items="${feedbacks}">

        <li>
            <label style="font-weight: bold;">Name: </label> ${emp.name}
            <label style="font-weight: bold;">Email: </label> ${emp.email}
            <label style="font-weight: bold;">Regarding: </label> ${emp.reg}
            <label style="font-weight: bold;">Code: </label> ${emp.code}
            <label style="font-weight: bold;">Message: </label> ${emp.msg}
            <label style="font-weight: bold;">Rating: </label> ${emp.rating}
        </li>

    </c:forEach>
</ol>

</body>
</html>