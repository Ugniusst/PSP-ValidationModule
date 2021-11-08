<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <p>User's additional information:</p>
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

        <button type="submit">Update</button>
    </form:form>
    <a href="/delete-user/${user.id}">Delete user</a>
</div>