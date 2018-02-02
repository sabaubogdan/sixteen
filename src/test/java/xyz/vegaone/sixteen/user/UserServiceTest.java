package xyz.vegaone.sixteen.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sixteen.dto.User;
import xyz.vegaone.sixteen.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    private static final String USER_FIRST_NAME = "John";
    private static final String USER_SECOND_NAME = "Smith";
    private static final String USER_EMAIL = "j.smith@vegaone.xyz";
    private static final String USER_PASSWORD = "password";
    private static final String NEW_USER_PASSWORD = "password";

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest(){
        //given

        //when
        User savedUser = buildAndSaveUser();

        //then
        Assert.assertNotNull("There should have been one user saved in the database", savedUser);
        Assert.assertEquals("The user first name should have matched", USER_FIRST_NAME, savedUser.getFirstName());
        Assert.assertEquals("The user second name should have matched", USER_SECOND_NAME, savedUser.getSecondName());
        Assert.assertEquals("The user email should have matched", USER_EMAIL, savedUser.getEmail());
        Assert.assertEquals("The user password should have matched", USER_PASSWORD, savedUser.getPassword());

    }

    @Test
    public void getUserTest(){
        //given
        User savedUser = buildAndSaveUser();

        //when
        User findUser = userService.getUser(savedUser.getId());

        //then
        Assert.assertNotNull("There should have been one user saved in the database", findUser);
        Assert.assertEquals("The user first name should have matched", USER_FIRST_NAME, findUser.getFirstName());
        Assert.assertEquals("The user second name should have matched", USER_SECOND_NAME, findUser.getSecondName());
        Assert.assertEquals("The user email should have matched", USER_EMAIL, findUser.getEmail());
        Assert.assertEquals("The user password should have matched", USER_PASSWORD, findUser.getPassword());

    }

    @Test
    public void deleteUserTest(){
        //given
        User savedUser = buildAndSaveUser();

        //when
        userService.deleteUser(savedUser.getId());

        //then
        Assert.assertNull("User should have been deleted from db", userService.getUser(savedUser.getId()));

    }

    @Test
    public void updateUserTest(){
        //given
        User savedUser = buildAndSaveUser();

        //when
        savedUser.setPassword(NEW_USER_PASSWORD);
        User updatedUser = userService.updateUser(savedUser);

        //then
        Assert.assertNotNull("There should have been one user saved in the database", updatedUser);
        Assert.assertEquals("The user password should have matched", NEW_USER_PASSWORD, updatedUser.getPassword());

    }

    private User buildAndSaveUser(){
        User user = new User();
        user.setFirstName(USER_FIRST_NAME);
        user.setSecondName(USER_SECOND_NAME);
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);

        return userService.createUser(user);
    }

}
