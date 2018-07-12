<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<table class="table table-sm bg-light">        
    <td>
    <nav class="nav">

        <a class="nav-link" href="/twitter-project">ГЛАВНАЯ</a>           

    </nav>
    </td>

    <td>
    <nav class="nav justify-content-end"> 
        
        <security:authorize access="isAnonymous()">     
            <a class="nav-link" href="/twitter-project/login">ВОЙТИ</a>
        </security:authorize> 
                
        
        <security:authorize access="isAuthenticated()">
            
            <a class="nav-link">
                <security:authentication property="principal.username"/>
            </a>
            
            <form id="exit" method="post" action="/twitter-project/logout">            

                <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" /> 

                <a class="nav-link" href="" onclick="document.forms['exit'].submit()">ВЫХОД</a>

            </form>
                
        </security:authorize>   
            
    </nav>
    </td>        
</table>