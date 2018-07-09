<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 

<style>  
    
</style>

<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" var="userName"/>
</security:authorize>
 

<spring:url value="/index" var="listURL"/> <!-- адрес который мэпит котроллер-->

<display:table name="list" id="row" requestURI="${listURL}" pagesize="10" class="table table-bordered table-hover"> <!-- 'list'- имя в моделвью-->
    
    <display:setProperty name="paging.banner.placement" value="both" />
    
    <display:column property="username" title="UserName"/>    
    <display:column property="text" title="Message"/>     
    
    <c:if test="${userName == row.username}">     
    <display:column title="Edit">         
        <button class="btn btn-outline-primary" type="button" onClick='location.href="/twitter-project/message/edit/${row.id}"'><i class="far fa-edit"></i></button>
    </display:column>
    </c:if>  
        
</display:table>
   