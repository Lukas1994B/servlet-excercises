package pl.sdacademy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class LoginValidatorTest {

    private LoginValidator loginValidatorSTU;

    private static String USERNAME = "JavaKtw9";
    private static String PASSWORD = "SDA2019";


    @Before
    public void setup(){
    loginValidatorSTU = new LoginValidator();
}

    @Test
    public void shouldReturnFalseWhenUserNameIsEmpty() {
        //given
        String userName = "SDA";
        //when
        boolean valid = loginValidatorSTU.isValid(USERNAME, PASSWORD);
        //then
        assertThat(valid, is(false));
    }


    @Test
    public void shouldReturnFalseWhenPasswordIsEmpty() {
        //given
        String password = "";
        //when
        boolean valid = loginValidatorSTU.isValid(password, null);
        //then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenUserNameIsShorterThan6Letters() {
        //given
        String userName = "Java";
        //when
        boolean valid = loginValidatorSTU.isValid(userName, null);
        //then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsShorterThan6Letters() {
        //given
        String userName = "SDA";
        //when
        boolean valid = loginValidatorSTU.isValid(userName, PASSWORD);
        //then
        assertThat(valid, is(false));
    }

//    @Test
//    public void shouldReturnTrueWhenPasswordAndUsernameMatch() {
//        //when
//        boolean valid = loginValidatorSTU.isValid(USERNAME, PASSWORD);
//        //then
//        assertThat(valid, is(true));
//
//    }
//
//    @Test
//    public void shouldReturnTrueWhenCareSensitive() {
//        //when
//        boolean valid = loginValidatorSTU.isValid(USERNAME, PASSWORD);
//        //then
//        assertThat(valid, is(false));
//
//    }


}
