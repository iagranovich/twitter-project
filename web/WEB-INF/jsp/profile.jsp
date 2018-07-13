<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <div class="col">
            <form:form commandName="user" method="POST" action="/twitter-project/profile">
          
                <form:errors path="nickname" class="alert alert-danger" element="div"/> 
                <form:label path="nickname">Ник:</form:label></br>
                <form:input path="nickname"/>      

                <form:input type="hidden"  path="id"  value="${user.id}"/>
                

                <small class="form-text text-muted">
                    Только латинские буквы и начало не с цифры.
                </small>  

                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"> 

                <input class="btn btn-success" type="submit" value="Сохранить">
                            
            </form:form>
        </div>
    </div>
</div>