package datamapper;

import entity.Bottom;
import java.util.ArrayList;
import entity.Topping;
import entity.User;

public interface DataMapperInterface
{
    public ArrayList<User> getUsers();
    public ArrayList<User> getUsers(String username);
    public User getUser(String username);
    public boolean deleteUser(String username);
    public boolean updateUser(User u);
    public boolean createUser(User u);
    public ArrayList<Topping> getAllToppings();
    public ArrayList<Bottom> getAllBottoms();
}