<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Andy's Cupcakes - Login</title>
    </head>
    <body>
                <%@include file="includes/menu.jsp" %>
        
        <div id="pricing" class="container-fluid">
            <div class="text-center">
            </div>
            <div class="row slideanim">
                <div class="col-sm-4 col-xs-12">

                </div>     
                <div class="col-sm-4 col-xs-12">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Login</h1>
                        </div>
                        <div class="panel-body">
                            <form action="Control" method="post">
                                <input type="text" name="username" value="" placeholder="Username" />
                                <input type="password" name="password" value="" placeholder="Password" />
                                <input type="hidden" name="origin" value="login" />
                                <br>
                                <br>
                                <br>
                                <input type="submit" value="Log in" />
                            </form>

                        </div>
                        <div class="panel-footer">

                        </div>
                    </div>      
                </div>       
                <div class="col-sm-4 col-xs-12">

                </div>    
            </div>
        </div>
        <br>
        <%@include file="includes/footer.jsp" %>

    </body>
</html>
