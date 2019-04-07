import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

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