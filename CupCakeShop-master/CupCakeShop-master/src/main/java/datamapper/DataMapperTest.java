package datamapper;

import datasource.DataSource1;
import entity.User;

public class DataMapperTest
{
    public static void main(String[] args)
    {
        DataMapper dm = new DataMapper(new DataSource1().getDataSource());
        
        System.out.println("getUsers: " + dm.getUsers().toString());
        User u1 = new User("Anders And", "123", 0, true);
        System.out.println("getUserByName: " + dm.getUser("Anders And"));
        System.out.println("createUser: " + dm.createUser(new User("Chip", "1234", 100, true)));
        System.out.println("updateUser: " + dm.updateUser(new User("Chap", "1234", 100, false)));
        System.out.println("deleteUser: " + dm.deleteUser("Anders And"));
        System.out.println("deleteUser: " + dm.validateUser("Chap", "1234"));

    }
}