package builder;

import br.ucsal.ucsalnews.entity.User;
import br.ucsal.ucsalnews.enums.Role;

public class UserBuilder {

    private static final String DEFAULT_NAME = "Jubileu";
    private static final String DEFAULT_USERNAME = "jubileu2021";
    private static final String DEFAULT_EMAIL = "jubileu@gmail.com";
    private static final String DEFAULT_PASSWORD = "1234feijao4321arroz";
    private static final Role DEFAULT_ROLE = Role.USER;

    private String name = DEFAULT_NAME;
    private String userName = DEFAULT_USERNAME;
    private String email = DEFAULT_EMAIL;
    private String password = DEFAULT_PASSWORD;
    private Role role = DEFAULT_ROLE;

    public static UserBuilder OneUser() {
        return new UserBuilder();
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.userName = username;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        User user = new User();
        user.setName(this.name);
        user.setUsername(this.userName);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setRole(this.role);

        return user;
    }
}
