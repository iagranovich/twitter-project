<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<security:authorize access="hasAnyAuthority('Admin', 'User')"> 
<security:authentication property="principal.username" var="userName"/>
<div>
<form:form commandName="message" method="POST" action="/twitter-project/message/new">
          
    <form:errors path="text" class="alert alert-danger" element="div"/>            

    <form:textarea path="text" rows="5" cols="50"></form:textarea>      
    
    <form:input type="hidden"  path="username"  value="${userName}"/>

    <small class="form-text text-muted">
        Максимальная длина сообщения 250 символов.
    </small>  

    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"> 

    <input class="btn btn-primary" type="submit" value="Добавить">
            
</form:form>
</div>        
</security:authorize>