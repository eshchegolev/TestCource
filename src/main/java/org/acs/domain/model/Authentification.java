package org.acs.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Сущность хранит логин и пароль, необходимый сущности VirtualUser
 * для получения ролей.
 * */
@Entity
public class Authentification {
    @Id
    private long id;
    private String login;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
