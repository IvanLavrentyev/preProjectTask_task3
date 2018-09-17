<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>--%>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="margin-top: 10%">
            <div>
                <p>Type of connection - ${typeOfConnection}</p>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>Name</th>
                            <th>LogIn</th>
                            <th>Password</th>
                            <th></th>
                        </tr>
                    </thread>
                    <tbody id="userList">
                    <c:forEach items="${users}" var="user">
                        <td>${user.name}</td>
                        <td>${user.login}</td>
                        <td>${user.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}"><button type="button" class="btn btn-primary">Delete</button></a>
                            <a href="${pageContext.request.contextPath}/updateUser?id=${user.id}"><button type="button" class="btn btn-primary">Update</button></a>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <hr>
                </table>
                <hr>

                <form action="${pageContext.request.contextPath}/addUser" method="post">
                    <div class="col-md-3">
                        <p>New user name.
                            <input type="text" name="name" size=15"/></p>
                    </div>
                    <div class="col-md-3">
                        <p>New user login.
                            <input type="text" name="login" size=15"/></p>
                    </div>
                    <div class="col-md-3">
                        <p>New user password.
                            <input type="text" name="password" size=15"></p>
                    </div>
                    <p>
                        <input type="submit"class="btn btn-primary" name="Add" value="Add"/>
                </form>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
<%--$('#Add').on('click', function () {--%>
<%--var name = document.getElementById('user-name').value;--%>
<%--var login = document.getElementById('user-login').value;--%>
<%--var password = document.getElementById('user-password').value;--%>

<%--var url = "/addUser";--%>

<%--$.ajax({--%>
<%--url:url,--%>
<%--method: "POST",--%>
<%--data: {userName : name, userLogin : login, userPassword : password},--%>

<%--success:--%>
<%--$.ajax({--%>
<%--url: "/allUsers",--%>
<%--method:"GET"--%>
<%--})--%>

<%--})--%>
<%--})--%>

<%--</script>--%>

</body>
</html>