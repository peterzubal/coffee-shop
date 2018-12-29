<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Andy's Cupcakes - Users</title>
    </head>
    <body>

        <%@include file="includes/menu.jsp" %>
        <h1  align="center">USERS</h1>
        <br>

        <div id="pricing" class="container-fluid">
            <div class="text-center">
            </div>
            <div class="row slideanim">
                <div class="col-sm-4 col-xs-12">
                </div>     
                <div class="col-sm-4 col-xs-12">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h1>Users Found</h1>                            
                        </div>
                        <div class="panel-body">
                            <%
                                ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");

                                if (users.size() > 0)
                                {
                                    out.println("<p>");

                                    for (User u : users)
                                    {
                                        out.println(u.getUsername() + "<br>");
                                    }

                                    out.println("</p>");
                                } else
                                {
                                    out.println("<p>No users found...</p>");
                                }

                            %>
                        </div>
                        <div class="panel-footer">
                        </div>
                    </div>      
                </div>       
                <div class="col-sm-4 col-xs-12">
                </div>    
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>

    </body>
</html>
