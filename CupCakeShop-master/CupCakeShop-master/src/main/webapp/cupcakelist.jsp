<%@page import="entity.Cupcake"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="servlet.Control"%>
<%@page import="entity.User"%>
<%@page import="entity.Cupcake"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Andy's Cupcakes - Shoppingcart</title>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        <h1  align="center">SHOPPING CART</h1>
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
                            <h1>Cart Items</h1>                            
                            <%
                                User user = (User) session.getAttribute("user");
                            %>
                            <%
                                out.print("Your Total Wallet Balance:" + " " + user.getBalance() + " " + "DDK");
                            %>
                        </div>
                        <div class="panel-body">



                            <br>
                            <%
                                @SuppressWarnings(  "unchecked")
                                ArrayList<Cupcake> list = (ArrayList<Cupcake>) request.getSession().getAttribute("shoppinglist");
                                out.println(list);
                            %>

                        </div>
                        <div class="panel-footer">
                            <form action="Control" method="post">
                                <input type="hidden" name="origin" value="buy" />
                                <input type="submit" value="BUY" />
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
