import java.util.List;

public interface UserDao {

    /**
     * Returns user with the given name or null if the user does not exist.
     * @param name
     * @return
     */
    User findUser(String name);

    /**
     * Removes given user if it exists, otherwise it throws RuntimeException.
     * @param user
     */
    void deleteUser(User user);

    /**
     * Returns a list of all the existing users.
     * @return
     */
    List<User> getAllUsers();
}
