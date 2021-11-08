<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <p>Add user:</p>
    <form:form method="post" modelAttribute="user">

        <form:label path="name">Name</form:label>
        <form:input path="name" type="text" required="required" />
        <form:errors path="name" />

        <br/>

        <form:label path="email">Email</form:label>
        <form:input path="email" type="text" required="required" />
        <form:errors path="email" />

        <br/>

        <form:label path="telephoneNumber">Telephone number</form:label>
        <form:input path="telephoneNumber" type="text" required="required" />
        <form:errors path="telephoneNumber" />

        <br/>

        <form:label path="address">Address</form:label>
        <form:input path="address" type="text" required="required" />
        <form:errors path="address" />

        <br/>
        <form:label path="password">Password</form:label>
        <form:input path="password" type="text" required="required" />
        <form:errors path="password" />

        <button type="submit">OK</button>
    </form:form>
</div>