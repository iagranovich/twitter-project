<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Bootstrap CSS -->        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
        <title>Main</title>
    </head>

    <body>
        
        <nav class="nav">
            <a class="nav-link" href="/twitter-project">Главная</a>
            <security:authorize access="isAnonymous()">     
                <a class="nav-link" href="login">Войти</a>
            </security:authorize>     
        </nav>
    
        <security:authorize access="hasAnyAuthority('Admin', 'User')">        
        <div>
        <form id="message" method="POST" action="/twitter-project/index.htm">
            <textarea rows="5" cols="50" name="text"></textarea>
            <small class="form-text text-muted">
                Максимальная длина сообщения 250 символов.
            </small>  
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"> 
            <input class="btn btn-primary" type="submit" value="Добавить">

            <div class="alert alert-danger" role="alert">
                Это основное уведомление — check it out!
            </div>
        </form>
        </div>        
        </security:authorize>
         
        <!--
        
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>Holy guacamole!</strong> You should check in on some of those fields below.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
  
  
  <div class="alert alert-success" role="alert">
    <h4 class="alert-heading">Отличная работа!</h4>
    <p>Вы успешно прочитали это важное сообщение. Это пример текста немного длиннее, так что вы увидите, как работает спейсинг в сообщениях уведомлений.</p>
    <hr>
    <p class="mb-0">Когда необходимо, используйте марджины для создания необходимых отступов.</p>

    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
    </button>
  </div>
  
        -->
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <table class="table table-bordered table-hover">
        <thead>
            <tr class="table-dark" >  
                <th>Messages</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="msg" items="${messages}">
                <tr class="table-primary">                            
                    <td><c:out value="${msg.text}"/></td> 
                </tr>
            </c:forEach> 
        </tbody>
        </table>

        
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
