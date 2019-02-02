package pl.sdacademy;


import org.apache.commons.lang3.StringUtils;

public class LoginValidator {


    /**
     * This method validates if user name are correct.
     * If userName or password are empty then return false.
     * If userName or password lenght is smaller than 6 then return false.
     * If userName is Javaktw9 and password is SDA2019 then return true.
     * UserName and password are case sensitive.
     *
     * @param userName
     * @param password
     * @return
     */
    boolean isValid(String userName, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password))
            return false;

        if (userName.length() < 6 || password.length() < 6) {
            return false;
        }
        return "JavaKTw9".equals(userName) && "Sda2019".equals(password);
    }
}
