package site.nomoreparties.stellarburgers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String email;
    private String password;

    public void setRandom(boolean isValidPassword) {
        this.username = RandomStringUtils.randomAlphanumeric(8);
        this.email = RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
        if (isValidPassword) {
            this.password = RandomStringUtils.randomAlphanumeric(8);
        }
        else {
            this.password = RandomStringUtils.randomAlphanumeric(4);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
