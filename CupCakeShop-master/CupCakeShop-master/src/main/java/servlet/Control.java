package servlet;

import datamapper.DataMapper;
import datasource.DataSource1;
import entity.Bottom;
import entity.Cupcake;
import entity.Topping;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Control", urlPatterns
        = {
            "/Control"
        })
public class Control extends HttpServlet {

    DataMapper dm;
    ArrayList<Cupcake> shoppinglist = new ArrayList<>();
    ArrayList<Cupcake> orderlist = new ArrayList<>();

    public Control() {
        dm = new DataMapper(new DataSource1().getDataSource());
    }

    /**
     * Takes case and executes what the User has posted.
     * <p>
     * Takes a post from a button on a jsp page with a string, e.g. "login" and
     * executes the case, like getting username and password and validating it,
     * before sending the User to a new page.
     * <p>
     * Used on all pages, via the top menu or buttons, e.g. login.jsp with the case "login".
     * @param request gets parameter "origin" then a case
     * @param response redirects to a page
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        switch (request.getParameter("origin")) {
            case "login": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                User user = dm.validateUser(username, password);

                request.getSession().setAttribute("user", user);

                //request.getRequestDispatcher("/user.jsp").forward(request, response);
                request.getSession().setAttribute("toppingslist", dm.getAllToppings());
                request.getSession().setAttribute("bottomslist", dm.getAllBottoms());

                response.sendRedirect("user.jsp");

            }
            break;
            

            case "buy": {

                shoppinglist.clear();
                response.sendRedirect("buy.jsp");

            }
            break;
            
            case "showorderlist": {
                request.getSession().setAttribute("orderlist", orderlist);
                response.sendRedirect("showorderlist.jsp");

            }
            break;

            case "search": {
                String username = request.getParameter("username");

//                    ArrayList<User> users = dm.getUsers(username);
                request.getSession().setAttribute("users", dm.getUsers(username));

                response.sendRedirect("users.jsp");

            }
            break;
            
            case "clear": {

                orderlist.clear();
                
                response.sendRedirect("showorderlist.jsp");

            }
            break;
            
            
            case "create": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int balance = Integer.parseInt(request.getParameter("balance"));

                boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

                dm.createUser(new User(username, password, balance, admin));

                response.sendRedirect("usercreated.jsp");

            }
            break;
            case "cupcake": {
                String t = request.getParameter("topping");
                String b = request.getParameter("bottom");
                Bottom bottom = null;
                Topping topping = null;

                ArrayList<Bottom> bl = (ArrayList<Bottom>) request.getSession().getAttribute("bottomslist");
                ArrayList<Topping> tl = (ArrayList<Topping>) request.getSession().getAttribute("toppingslist");

                for (Topping toppingl : tl) {
                    if (toppingl.getName().equals(t)) {

                        topping = toppingl;
                    }
                }

                for (Bottom bottoml : bl) {
                    if (bottoml.getName().equals(b)) {

                        bottom = bottoml;
                    }
                }

                Cupcake cupcake = new Cupcake(topping, bottom);
                shoppinglist.add(cupcake);
                orderlist.add(cupcake);
                request.getSession().setAttribute("shoppinglist", shoppinglist);

                dm.createCupcake(cupcake);
                
                
                getServletContext().getRequestDispatcher("/products.jsp").forward(request, response); // 

                response.sendRedirect("products.jsp");

            }
            break;
            case "delete": {
                User user = (User) request.getSession().getAttribute("user");

                if (user != null) {
                    dm.deleteUser(user.getUsername());

                    response.sendRedirect("userdeleted.jsp");
                }

            }
            break;
        }

    }

    
    /**
     * Call for proccessRequest.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Call for processRequest
     * @param request 
     * @param response 
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    
    /**
     * Returns short description of Servlet
     * <p>
     * Unused
     * @return 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
