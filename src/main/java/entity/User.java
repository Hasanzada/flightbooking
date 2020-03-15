package entity;


import java.io.Serializable;

public class User implements Serializable, Identifiable {

    private long id;
    private String login;
    private String password;

    private static final long serialVersionUID = 4L;

    public User() {
    }

    public User(long id,  String login,  String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("id: %d login %S ",id,login);
    }
}
