<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Andy's Cupcakes - user</title> 
    </head>
    <body>
                       <%@include file="includes/menu.jsp" %>

        <h1  align="center">USER</h1>
        <br>


        <div id="pricing" class="container-fluid">
            <div class="text-center">
            </div>
            <div class="row slideanim">
                <div class="col-sm-4 col-xs-12">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Order History</h1>
                        </div>
                        <div class="panel-body">


                            <form action="Control" method="post">
                                <input type="hidden" name="origin" value="showorderlist" />
                                <input type="submit" value="Show Order History" />
                            </form>


                        </div>
                        <div class="panel-footer">
                        </div>
                    </div>      
                </div>     
                <div class="col-sm-4 col-xs-12">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Bottoms</h1>
                        </div>
                        <div class="panel-body">
                            <%
                                User user = (User) session.getAttribute("user");

                                if (user != null)
                                {
                                    out.print("Login worked!");
                                } else
                                {
                                    out.print("Login failed");

                                    user = new User("Anonymous", "none", false);
                                }

                            %>
                            <p>
                                Logged in as: <%= user.getUsername()%><br>
                                Total Wallet Balance: <%= user.getBalance()%><br>
                                Admin: <%= user.isAdmin()%><br>
                            </p>
                        </div>
                        <div class="panel-footer">

                        </div>
                    </div>      
                </div>       
                <div class="col-sm-4 col-xs-12">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Delete User</h1>
                        </div>
                        <div class="panel-body">
                            <form action="Control" method="post">
                                <input type="hidden" name="origin" value="delete" />
                                <input type="submit" value="DELETE USER" />
                            </form>
                        </div>
                        <div class="panel-footer">

                        </div>
                    </div>      
                </div>    
            </div>
        </div>

        <%@include file="includes/footer.jsp" %> 
        
</body>
</html>
