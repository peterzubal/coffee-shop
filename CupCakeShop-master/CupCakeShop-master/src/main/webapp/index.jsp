<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Andy's Cupcakes - frontpage</title>


    </head>        
    <style>
        p,h1,h2{
            color: #E1C8B4;
        }

        #picture{
            height:400px;
            width:280px;
            display: block;
            margin-left: auto;
            margin-right: auto;
            float:none;
            position: initial;
        }
    </style>

    <body style="background-color: #965115;">

        <%@include file="includes/menu.jsp" %>

    <center><h1>Andy's Cupcakes</h1></center>

    <img id="picture" src="https://prettysimplesweet.com/wp-content/uploads/2015/07/Double-Chocolate-Cupcakes-1.jpg" alt="CupCake">

    <div>
        <center><h2>SEARCH USER</h2></center>

        <div>

            <form id="formSearch" action="Control" method="post">
                <label id="labelUsername" for="username">Username</label>
                <input type="text" name="username" />
                <input type="hidden" name="origin" value="search" />
                <input type="submit" value="SEARCH USER" />
            </form>

            <center><h2>CREATE USER</h2></center>

            <form id="formCreate" action="Control" method="post">
                <label id="labelUsername" for="username">Username</label>
                <input type="text" name="username" />
                <label id="labelPassword" for="password">Password</label>
                <input type="text" name="password" />
                <label id="labelBalance"for="balance">balance</label>
                <input type="number"name="balance"/>
                <label id="labelAdmin" for="admin">Admin</label>
                <input type="text" name="admin" />
                <input type="hidden" name="origin" value="create" />
                <input type="submit" value="CREATE USER" />
            </form>

        </div>

    </div>
    <%@include file="includes/footer.jsp" %>
</body>
</html>
