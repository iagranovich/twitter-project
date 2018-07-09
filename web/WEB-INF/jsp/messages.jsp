<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" var="userName"/>
</security:authorize>
    
<table class="table table-bordered table-hover">
    <thead>
        <tr class="table-dark" >  
            <th>Messages</th>
            <th>Edit</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="msg" items="${messages}">
            <tr class="table-primary">                            
                <td>
                    <b>${msg.username}</b> - "${msg.text}"
                </td> 
                <td>
                    <c:if test="${userName == msg.username}">                          
                        <button class="btn btn-primary" type="button" onClick='location.href="/twitter-project/message/edit/${msg.id}"'>Карандашег</button>
                    </c:if>                   
                </td>
            </tr>
        </c:forEach> 
    </tbody>
</table>