package datamapper;

import entity.User;
import java.util.ArrayList;
import dbconnector.DBConnector;
import entity.Bottom;
import entity.Cupcake;
import entity.Topping;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMapper implements DataMapperInterface
{
    private DBConnector dbc = new DBConnector();

    public DataMapper(DataSource ds)
    {
        dbc.setDataSource(ds);
    }

    
    /**
     * Returns Users with no keyword given, used for searching for Users.
     * <p>
     * Makes a list of all Users from the database, if a String keyword 
     * is given (not null) getUsers(String un) is used instead.
     * <p>
     * Used on index.jsp for searching Users.
     * @return Users 
     */
    @Override
    public ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from user";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int userbalance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("admin");

                User u = new User(username, userpassword, userbalance, admin);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    
    /**
     *Returns Users with a typed keyword, used for searching for Users.
     * <p>
     * Makes a list of Users from a keyword, if no String keyword 
     * is given (null) getUsers() is used instead.
     * <p>
     * Used on index.jsp for searching Users.
     * @param un not null
     * @return Users
     */
    @Override
    public ArrayList<User> getUsers(String un)
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from user where username like '%" + un + "%'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {

                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int userbalance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("admin");

                User u = new User(username, userpassword, userbalance, admin);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    
    /**
     * Returns User from a name.
     * <p>
     * Returns a User from a given String name, finding the User in the database.
     * <p>
     * Currently only used for testing on DataMapperTest.
     * @param name not null
     * @return
     */
    @Override
    public User getUser(String name)
    {
        try
        {
            dbc.open();

            String sql = "select * from user where username = '" + name + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int userbalance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("admin");

                return new User(username, userpassword, userbalance, admin);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    
    /**
     * Deletes a User from a name.
     * <p>
     * Deletes a User with a given String username from the database.
     * <p>
     * Used on user.jsp for deleting a User.
     * @param username not null
     * @return
     */
    @Override
    public boolean deleteUser(String username)
    {
        try
        {
            dbc.open();

//            String sql = "delete from team_user where user_id = " + id + ";";
//            dbc.executeUpdate(sql);

            String sql = "delete from user where username = " + "'" + username + "'" + ";";
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    
    /**
     * Updates a User with new information.
     * <p>
     * Updates an existing Users username, password, balance and/or admin status.
     * <p>
     * Currently unused.
     * @param u 
     * @return
     */
    @Override
    public boolean updateUser(User u)
    {
        try
        {
            dbc.open();

            String sql = "update user set "
                    + "username = '" + u.getUsername() + "', "
                    + "password = '" + u.getPassword() + "', "
                    + "balance = '" + u.getBalance() + "', "
                    + "admin = '" + u.isAdmin() + "' "
                    + "where username = '" + u.getUsername() + "';";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    
    /**
     * Creates a new User.
     * <p>
     * Creates a new User and adds the User to the database.
     * <p>
     * Only Balance and Admin can be left null, as they will default to 0.
     * <p>
     * Used on index.jsp for creating a new User.
     * @param u (Username, Password not null)
     * @return
     */
    @Override
    public boolean createUser(User u)
    {
        try
        {
            dbc.open();

            String sql = "insert into user values("
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword() + "', "
                    + "'" + u.getBalance() + "', "
                    + u.isAdmin() + ")";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    
    /**
     * Inserts a Cupcake object into the database.
     * <p>
     * Gets the Cupcake objects Topping, Bottom and Full price and inserts it
     * into the database as a Cupcake.
     * <p>
     * Used on products.jsp for inserting Cupcakes in the database.
     * @param c not null
     * @return
     */
    public boolean createCupcake(Cupcake c)
    {
        try
        {
            dbc.open();

            String sql = "insert into cupcakes values("
                    + "'" + c.getT()+ "', "
                    + "'" + c.getB()+ "', "
                    + "'" + c.getFullPrice()+ "')";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    
    /**
     * Validates a User for login.
     * <p>
     * Validates a User by the username and password given, and logs in
     * if unsuccessful then as anonymous user.
     * <p>
     * Used on login.jsp for validating a User.
     * @param username
     * @param password
     * @return User
     */
    public User validateUser(String username, String password)
    {
        User user = null;
        
        try
        {
            dbc.open();
            
            /*
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println("SQL: " + sql);
            ResultSet resultSet = dbc.executeQuery(sql);
            */
            
            //PreparedStatement
            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
                username = resultSet.getString("username");
                boolean admin = resultSet.getInt("admin") > 0;
                int balance = resultSet.getInt("balance");
                user = new User(username, password,balance ,admin);
            }

            dbc.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }
    
    
    /**
     * Gets all Toppings from the database.
     * <p>
     * Returns an arraylist of Toppings found in the database.
     * <p>
     * Used on products.jsp and User session.
     * @return toppings
     */
    @Override
    public ArrayList<Topping> getAllToppings()
    {
        ArrayList<Topping> toppings = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from toppings";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String topping = resultset.getString("topping");
                int price = resultset.getInt("price");

                Topping t = new Topping(topping, price);

                toppings.add(t);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toppings;
    }
    
    
    /**
     * Gets all Bottoms from the database.
     * <p>
     * Returns an arraylist of Bottoms found in the database.
     * <p>
     * Used on products.jsp and User session
     * @return bottoms
     */
    @Override
    public ArrayList<Bottom> getAllBottoms()
    {
        ArrayList<Bottom> bottoms = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from bottoms";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                String bottom = resultset.getString("bottom");
                int price = resultset.getInt("price");

                Bottom b = new Bottom(bottom, price);

                bottoms.add(b);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bottoms;
    }
    
}