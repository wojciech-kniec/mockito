import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
        // given
        List<User> users = Arrays.asList(
                new User("user1"), new User("user2"), new User("user3"), new User("user4"));
        when(userDao.getAllUsers()).thenReturn(users);
        // when
        List<User> result = userService.getAllUsers();
        // then
        assertThat(result).hasSize(4);

    }

    @Test
    public void shouldReturnAllUsersMatchingPattern() {
        // given
        List<User> allUsers = List.of(
                new User("Kowalski"),
                new User("Nowak"),
                new User("ABS"),
                new User("aweawe"));

        when(userDao.getAllUsers()).thenReturn(allUsers);


        // when
        List<User> result = userService.findUsers("ow");
        // then
        assertThat(result).hasSize(2)
                .contains(
                        new User("Kowalski"),
                        new User("Nowak")
                );
    }

    @Test
    public void shouldReturnTrueIfUserExists() {

        //given
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        when(userDao.findUser(nameCaptor.capture()))
                .thenReturn(new User("admin"));
        //when
        boolean result = userService.doesUserExist("admin");
        //then
        assertThat(result).isTrue();
        assertThat(nameCaptor.getValue()).isEqualTo("admin");
    }

    @Test
    public void shouldReturnFalseIfUserDoesNotExist() {
        when(userDao.findUser(eq("janek1")))
                .thenReturn(null);


        //when
        boolean result = userService.doesUserExist("janek1");

        //then
        assertThat(result).isFalse();

    }

    @Test
    public void shouldThrowExceptionWhenRemovingNonExistingUser() {
        // Zadanie 5


        //given
        doThrow(new RuntimeException()).when(userDao).deleteUser(eq(new User("ania13")));
        //when

        //then
        assertThrows(RuntimeException.class,
                () -> userService.deleteUser(new User("ania13")));
    }
}