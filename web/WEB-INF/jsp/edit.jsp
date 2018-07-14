<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<security:authentication property="principal.username" var="userName"/>
<c:choose>
<c:when test="${userName != message.username}">
    <div class="alert alert-danger" role="alert">
        Вы не можете редактировать чужие сообщения!    
    </div>    
</c:when>
<c:otherwise>
    <form:form commandName="message" method="POST" action="/twitter-project/message/edit">

        <form:errors path="text" class="alert alert-danger" element="div"/>            

        <form:textarea path="text" rows="5" cols="50"></form:textarea>      

        <form:input type="hidden"  path="username"  value="${message.username}"/>
        <form:input type="hidden"  path="date"  value="${message.date}"/>
        <form:input type="hidden"  path="id"  value="${message.id}"/>

        <small class="form-text text-muted">
            Максимальная длина сообщения 250 символов.
        </small>  

        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"> 

        <input class="btn btn-success" type="submit" value="Сохранить">
        <button class="btn btn-danger" type="button" onClick='location.href="/twitter-project"'>Отмена</button>


    </form:form>
</c:otherwise>
</c:choose>
