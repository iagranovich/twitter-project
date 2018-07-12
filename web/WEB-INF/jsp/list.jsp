<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 

<style>  
    
</style>


<spring:url value="/index" var="listURL"/> <!-- url который мэпится котроллером-->

<display:table name="list" id="message" requestURI="${listURL}" pagesize="10" class="table table-hover"> <!-- 'list'- имя в моделвью-->
    
    <display:setProperty name="paging.banner.placement" value="both" />
    <display:setProperty name="paging.banner.item_name" value="message" />
    <display:setProperty name="paging.banner.items_name" value="messages" />
    
    <display:setProperty name="paging.banner.page.separator" value="" />
    <display:setProperty name="paging.banner.page.link" value="<li class='page-item'><a class='page-link' href={1}>{0}</a></li>" />
    <display:setProperty name="paging.banner.page.selected" value="<li class='page-item active'><span class='page-link'>{0}<span class='sr-only'>(current)</span></span></li>" />
    
    <display:setProperty name="paging.banner.full" value='<nav aria-label="Page navigation"><ul class="pagination"><li class="page-item"><a class="page-link" href={2}>Previous</a></li>{0}<li class="page-item"><a class="page-link" href={3}>Next</a></li></ul></nav>' />    
    <display:setProperty name="paging.banner.first" value='<nav aria-label="Page navigation"><ul class="pagination"><li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>{0}<li class="page-item"><a class="page-link" href={3}>Next</a></li> </ul></nav>' />    
    <display:setProperty name="paging.banner.last" value='<nav aria-label="Page navigation"><ul class="pagination"><li class="page-item"><a class="page-link" href={2}>Previous</a></li>{0}<li class="page-item disabled"><a class="page-link" href="#">Next</a></li> </ul></nav>' />
    <display:setProperty name="paging.banner.onepage" value='<nav aria-label="Page navigation"><ul class="pagination"><li class="page-item disabled"><a class="page-link" href={2}>Previous</a></li>{0}<li class="page-item disabled"><a class="page-link" href="#">Next</a></li> </ul></nav>'/>
    
    
    <display:column title="Messages"> 
        
        <b>${message.username}</b>
        </br>${message.text}
        </br><span class="badge badge-primary">retweet</span>
        
    </display:column>
    
    <display:column title="">
        <security:authorize access="isAuthenticated()">
            <security:authentication property="principal.username" var="userName"/>
        
            <c:if test="${userName == message.username}">    
                <button class="btn btn-primary" type="button" onClick='location.href="/twitter-project/message/edit/${message.id}"'><i class="far fa-edit"></i></button>
            </c:if>  
                
            <c:choose>
                <c:when test="${userName != message.username and retweets.contains(message.id)}">    
                    <button class="btn btn-primary" type="button" disabled><i class="fas fa-retweet"></i></button>
                </c:when>
                <c:when test="${userName != message.username and not retweets.contains(message.id)}">    
                    <button class="btn btn-primary" type="button" onClick='location.href="/twitter-project/message/retweet/${message.id}"'><i class="fas fa-retweet"></i></button>
                </c:when>                
            </c:choose>
                
        </security:authorize>
    </display:column>    
        
</display:table>
   