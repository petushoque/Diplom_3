package site.nomoreparties.stellarburgers;

import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User getRandom() {
        String username = RandomStringUtils.randomAlphanumeric(8);
        String email = RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
        String password = RandomStringUtils.randomAlphanumeric(8);

        return new User(username, email, password);
    }
}
