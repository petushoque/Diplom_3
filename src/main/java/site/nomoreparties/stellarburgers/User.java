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

    public void setRandom() {
        this.username = RandomStringUtils.randomAlphanumeric(8);
        this.email = RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
        this.password = RandomStringUtils.randomAlphanumeric(8);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
