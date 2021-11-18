package br.ucsal.ucsalnews.dto.response;

import br.ucsal.ucsalnews.entity.User;

public class UserDTOResponse {

    private Long id;

    private String name;

    private String userName;

    private String email;

    public UserDTOResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userName = user.getUsername();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
