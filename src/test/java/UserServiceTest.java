import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

//    @Mock
    private UserDao userDao;

//    @InjectMocks
    private UserService userService; //= new UserService(userDao);

    @BeforeEach
    public void setUp() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
    }

    @Test
    public void returnFromMock() {
        User user = userDao.findUser("jan");
        System.out.println(user);

        List<User> users = userService.getAllUsers();
        System.out.println(users);
    }

    @Test
    public void shouldGetAllUsers() {
        // Zadanie 1
    }

    @Test
    public void shouldReturnAllUsersMatchingPattern() {
        // Zadanie 2
    }

    @Test
    public void shouldReturnTrueIfUserExists() {
        // Zadanie 3
    }

    @Test
    public void shouldReturnFalseIfUserDoesNotExist() {
        // Zadanie 4
    }

    @Test
    public void shouldThrowExceptionWhenRemovingNonExistingUser() {
        // Zadanie 5
    }
}