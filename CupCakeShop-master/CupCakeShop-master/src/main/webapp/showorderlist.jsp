<%-- 
    Document   : showorderlist
    Created on : 02-03-2018, 11:46:22
    Author     : RasmusFriis
--%>

<%@page import="entity.Cupcake"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Andy's Cupcakes - Order History</title>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>


        <h1  align="center">ORDER HISTORY</h1>
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
                            <h1>Items</h1>
                        </div>
                        <div class="panel-body">
                            <%
                                User user = (User) session.getAttribute("user");
                            %>
                            <br>
                            <%
                                ArrayList<Cupcake> list = (ArrayList<Cupcake>) request.getSession().getAttribute("orderlist");
                                out.println(list);
                            %>

                        </div>
                        <div class="panel-footer">

                            <form action="Control" method="post">
                                <input type="hidden" name="origin" value="clear" />
                                <input type="submit" value="CLEAR" />
                            </form>
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
